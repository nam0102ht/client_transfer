package com.ntnn.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.Data;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
@ConfigurationProperties(prefix = "jasypt.encryptor")
@Data
public class JasyptConfig {
    private String algorithm;
    private String providerName;
    private String password;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        SimpleStringPBEConfig stringPBEConfig = new SimpleStringPBEConfig();
        stringPBEConfig.setProviderName(providerName);
        stringPBEConfig.setPassword(password);
        stringPBEConfig.setAlgorithm(algorithm);
        stringPBEConfig.setPoolSize(1);
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(stringPBEConfig);
        return encryptor;
    }
}
