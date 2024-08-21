package com.ntnn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DiffieHellmanRequest {
  private String publicKey;
  private String secretKey;
  private String salt;
  private String pepper;
}
