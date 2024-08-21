package com.ntnn.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DiffieHellmanResponse {
  private String publicKey;
  private String publicKeySever;
  private String secretKey;
  private String secretKeyAgreement;
  private String apiId;
  private String salt;
  private String pepper;
}