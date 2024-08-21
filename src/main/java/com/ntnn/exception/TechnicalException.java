package com.ntnn.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class TechnicalException extends RuntimeException {
  private String message;
  private String errorCode;

  public TechnicalException(String errorCode, String message) {
    this.message = message;
    this.errorCode = errorCode;
  }

  public TechnicalException(String errorCode, String message, Exception ex) {
    this.message = message;
    this.errorCode = errorCode;
    log.error("Exception={}", ex.getMessage(), ex);
  }
}
