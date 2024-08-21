package com.ntnn.helper;

public class InvalidInputException extends RuntimeException {
  private String message;

  public InvalidInputException(String message) {
    this.message = message;
  }
}
