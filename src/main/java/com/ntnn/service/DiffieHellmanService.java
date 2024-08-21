package com.ntnn.service;

import com.ntnn.dto.AgronDto;
import com.ntnn.dto.DiffieHellmanRequest;
import com.ntnn.dto.DiffieHellmanResponse;
import com.ntnn.entity.KeyStorage;
import com.ntnn.exception.TechnicalException;
import com.ntnn.helper.InvalidInputException;
import com.ntnn.helper.SecurityHelper;
import com.ntnn.repository.KeyStoreRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.crypto.KeyAgreement;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiffieHellmanService {
  @Value("${downstream.server}")
  private String urlDiffieHellman;
  private final KeyStoreRepository keyStoreRepository;

  @Transactional
  public DiffieHellmanResponse diffieHellman() {
    try {
      ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");

      KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
      keyGen.initialize(parameterSpec);
      KeyPair keyPair = keyGen.generateKeyPair();

      Key privateKey = keyPair.getPrivate();
      byte[] privateCodeBytes = privateKey.getEncoded();
      String privateKeyString = Base64.getEncoder().encodeToString(privateCodeBytes);

      KeyStorage keyStorage = new KeyStorage();
      keyStorage.setPrivateKey(privateKeyString);
      Key publicKey = keyPair.getPublic();

      DiffieHellmanRequest diffieHellmanRequest = DiffieHellmanRequest
          .builder()
          .publicKey(Base64.getEncoder().encodeToString(publicKey.getEncoded()))
          .build();

      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<DiffieHellmanResponse> diffieHellmanResponseResponseEntity = restTemplate.postForEntity(String.join("", urlDiffieHellman, "/diffieHellman/exchangeKey"), diffieHellmanRequest, DiffieHellmanResponse.class);

      if (!diffieHellmanResponseResponseEntity.getStatusCode().is2xxSuccessful()) {
        throw new TechnicalException(diffieHellmanResponseResponseEntity.getStatusCode().toString(), "Something is wrong when calling to url:'%s'".formatted(urlDiffieHellman));
      }


      DiffieHellmanResponse diffieHellmanResponse = diffieHellmanResponseResponseEntity.getBody();

      assert diffieHellmanResponse != null;

      byte[] publicKeyBytesServer = Base64.getDecoder().decode(diffieHellmanResponse.getPublicKeySever());
      EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytesServer);
      KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
      PublicKey publicKeyServer = keyFactory.generatePublic(publicKeySpec);

      String publicKeyClient = Base64.getEncoder().encodeToString(publicKey.getEncoded());
      KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH", "BC");
      keyAgreement.init(privateKey);
      keyAgreement.doPhase(publicKeyServer, true);
      byte[] sharedSecret = keyAgreement.generateSecret();
      String sharedSecretBytes = Base64.getEncoder().encodeToString(sharedSecret);

      if (!sharedSecretBytes.equals(diffieHellmanResponse.getSecretKey())) {
        throw new TechnicalException("500", "Shared key not equals");
      }

      keyStorage.setPublicKey(diffieHellmanResponse.getPublicKeySever());
      keyStorage.setSalt(diffieHellmanResponse.getSalt());
      keyStorage.setPepper(diffieHellmanResponse.getPepper());
      keyStorage.setSecretKeyAgreement(diffieHellmanResponse.getSecretKeyAgreement());
      keyStorage.setPublicKeyClient(publicKeyClient);
      keyStorage.setSecretKey(sharedSecretBytes);
      keyStorage.setId(diffieHellmanResponse.getApiId());

      KeyStorage keySaved = keyStoreRepository.save(keyStorage);

      return DiffieHellmanResponse.builder()
          .apiId(keySaved.getId())
          .salt(keySaved.getSalt())
          .publicKeySever(diffieHellmanResponse.getPublicKeySever())
          .publicKey(publicKeyClient)
          .secretKey(sharedSecretBytes)
          .pepper(keySaved.getPepper())
          .build();
    } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException exception) {
      throw new TechnicalException("999", exception.getMessage());
    } catch (InvalidKeyException e) {
      throw new RuntimeException(e);
    } catch (InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
  }

  public String signature(String apId) {
    try {
      KeyStorage keyStorage = keyStoreRepository.findById(apId).orElseThrow(() -> {
        throw new InvalidInputException("Invalid input apId");
      });

      byte[] privatKeyBytes = Base64.getDecoder().decode(keyStorage.getPrivateKey());
      PrivateKey severPrivateKey = KeyFactory.getInstance("EC", "BC")
          .generatePrivate(new PKCS8EncodedKeySpec(privatKeyBytes));

      // Sign the message using shared secret
      Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
      signature.initSign(severPrivateKey);
      signature.update(Base64.getDecoder().decode(keyStorage.getSecretKey()));

      byte[] signatureBytes = signature.sign();
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("apId", keyStorage.getId());
      jsonObject.put("keyAgreement", keyStorage.getSecretKeyAgreement());
      jsonObject.put("dataSign", Base64.getEncoder().encodeToString(signatureBytes));
      jsonObject.put("salt", keyStorage.getSalt());
      jsonObject.put("pepper", keyStorage.getPepper());
      jsonObject.put("secretKey", keyStorage.getSecretKey());

      return Base64.getEncoder().encodeToString(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
    } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException | SignatureException |
             InvalidKeyException exception) {
      log.error("Exception={}", exception.getMessage(), exception);
      throw new TechnicalException("999", exception.getMessage(), exception);
    }
  }
}
