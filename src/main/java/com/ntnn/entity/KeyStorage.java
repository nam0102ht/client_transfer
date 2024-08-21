package com.ntnn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "KEY_VAULT")
@EqualsAndHashCode
@Entity(name = "keyVault")
public class KeyStorage {
  @Id
  @Column(name = "ID")
  private String id;

  @Column(name = "PRIVATE_KEY")
  private String privateKey;

  @Column(name = "PUBLIC_KEY")
  private String publicKey;

  @Column(name = "SECRET_KEY_AGREEMENT")
  private String secretKeyAgreement;

  @Column(name = "PUBLIC_KEY_CLIENT")
  private String publicKeyClient;

  @Column(name = "SECRET_KEY")
  private String secretKey;

  @Column(name = "EXPIRE_TIME")
  private String expireTime;

  @Column(name = "SALT")
  private String salt;

  @Column(name = "PEPPER")
  private String pepper;
}
