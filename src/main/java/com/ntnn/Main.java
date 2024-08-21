package com.ntnn;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.security.Security;

@SpringBootApplication
@EnableAsync
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  static {
    Security.addProvider(new BouncyCastleProvider());
  }
}