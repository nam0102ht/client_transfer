package com.ntnn.service;

import com.ntnn.dto.GenericSingleRestResponse;
import com.ntnn.helper.InvalidInputException;
import com.ntnn.helper.XmlParser;
import com.ntnn.wsld.Document;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopupService {

  private final XmlParser xmlParser;
  private final DiffieHellmanService diffieHellmanService;

  @Value("${downstream.server}")
  private String urlServer;

  public GenericSingleRestResponse topup(HttpHeaders httpServletRequest, String xmlDocument, String accountId) {
    try {
      String authorization = Objects.requireNonNull(httpServletRequest.get("Authorization")).get(0);
      String[] basicToken = authorization.split(" ");
      if (basicToken.length < 2) {
        throw new InvalidInputException("Api not include the basic token");
      }
      String apid = "";
      if (basicToken[0].equals("Bearer")) {
        apid = new String(Base64.getDecoder().decode(basicToken[1]));
      }
      Document document = xmlParser.transformXmlToObject(xmlDocument);
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = createHttpHeaders(apid);
      return restTemplate.exchange(RequestEntity.post(new URI(urlServer + "/transaction/topup/" + accountId)).headers(headers).body(xmlDocument), GenericSingleRestResponse.class).getBody();
    } catch (Exception ex) {
      log.error("Error with msg='{}'", ex.getMessage(), ex);
    }
    return null;
  }

  private HttpHeaders createHttpHeaders(String apId)
  {
    HttpHeaders headers = new HttpHeaders();
    String signature = diffieHellmanService.signature(apId);
    headers.setBearerAuth(signature);
    log.info("Signature: {}", signature);
    headers.setContentType(MediaType.APPLICATION_XML);
    return headers;
  }
}
