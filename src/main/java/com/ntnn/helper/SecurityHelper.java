package com.ntnn.helper;

import com.ntnn.dto.AgronDto;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@UtilityClass
@Slf4j
public class SecurityHelper {
  public static AgronDto passwordAgron2Encrypt(String password) throws NoSuchAlgorithmException {
    Argon2BytesGenerator generator = new Argon2BytesGenerator();
    Argon2Parameters.Builder builder = new Argon2Parameters.Builder();

    //Salt and Pepper Length should be at least 8 Byte, 16 bytes is sufficient for all applications
    byte[] salt = new byte[16];
    byte[] pepper = new byte[16];
    SecureRandom.getInstanceStrong().nextBytes(salt);
    SecureRandom.getInstanceStrong().nextBytes(pepper);

    //Choose a hash length - for security reason choose 128 for password hashing (can be lowered to 16 for non-secure applications)
    byte[] hash = new byte[128];

    //Set the number of Iterations each call -> More Iterations = Better Security + more Hashing Time
    // > 3 Iterations recommended
    builder.withIterations(3);

    //Figure out how much memory each call can afford (memory_cost).
    //The RFC recommends 4 GB for backend authentication and 1 GB for frontend authentication.
    //The APIs uses Kibibytes (1024 bytes) as base unit.
    builder.withMemoryAsKB(1024000);

    //Choose the Number of CPU-Threads you can afford each call (2 Cores = 4 Threads)
    builder.withParallelism(4);

    //Choose a "salt" which can be stored non-secure or with the password Hash
    builder.withSalt(salt);

    //Choose a Secret "pepper" which has to be stored in a different secure location from the password hashes
    builder.withSecret(pepper);

    //Choose whether you want  Argon2d: 0, Argon2i: 1, Argon2id: 2, Argon2_version_10: 16, Argon2_version_13: 19
    //Argon2i is recommended for password Hashing
    builder.withVersion(1);

    Argon2Parameters parameters = builder.build();
    log.info("Salt used:  {} and Pepper used !!Store securely!!: {}", Base64.getEncoder().encodeToString(parameters.getSalt()),  Base64.getEncoder().encodeToString(parameters.getSecret()));

    generator.init(parameters);
    generator.generateBytes(password.toCharArray(), hash);
    AgronDto agronDto = new AgronDto();
    agronDto.setPassword(Base64.getEncoder().encodeToString(hash));
    agronDto.setSalt(Base64.getEncoder().encodeToString(parameters.getSalt()));
    agronDto.setPepper(Base64.getEncoder().encodeToString(parameters.getSecret()));
    return agronDto;
  }

  public static boolean passwordAgron2Validate(AgronDto agronDto, String hashPassword) throws NoSuchAlgorithmException {
    Argon2BytesGenerator generator = new Argon2BytesGenerator();
    Argon2Parameters.Builder builder = new Argon2Parameters.Builder();

    //Salt and Pepper Length should be at least 8 Byte, 16 bytes is sufficient for all applications
    byte[] bytes = Base64.getDecoder().decode(agronDto.getPassword());
    byte[] salt = Base64.getDecoder().decode(agronDto.getSalt());
    byte[] pepper = Base64.getDecoder().decode(agronDto.getPepper());
    //Set the number of Iterations each call -> More Iterations = Better Security + more Hashing Time
    // > 3 Iterations recommended
    builder.withIterations(3);

    //Figure out how much memory each call can afford (memory_cost).
    //The RFC recommends 4 GB for backend authentication and 1 GB for frontend authentication.
    //The APIs uses Kibibytes (1024 bytes) as base unit.
    builder.withMemoryAsKB(1024000);

    //Choose the Number of CPU-Threads you can afford each call (2 Cores = 4 Threads)
    builder.withParallelism(4);

    //Choose a "salt" which can be stored non-secure or with the password Hash
    builder.withSalt(salt);

    //Choose a Secret "pepper" which has to be stored in a different secure location from the password hashes
    builder.withSecret(pepper);

    //Choose whether you want  Argon2d: 0, Argon2i: 1, Argon2id: 2, Argon2_version_10: 16, Argon2_version_13: 19
    //Argon2i is recommended for password Hashing
    builder.withVersion(1);

    Argon2Parameters parameters = builder.build();
    generator.init(parameters);
    byte[] hashToVerify = new byte[bytes.length];
    generator.generateBytes(hashPassword.getBytes(), hashToVerify, 0, hashToVerify.length);
    if (Arrays.equals(hashToVerify, bytes)) {
      return true;
    }
    return false;
  }

}
