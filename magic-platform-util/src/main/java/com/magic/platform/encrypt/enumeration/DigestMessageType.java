package com.magic.platform.encrypt.enumeration;


public enum DigestMessageType {
  MD5("MD5"),
  SHA("SHA"),
  SHA256("SHA-256"),
  SHA384("SHA-384"),
  SHA512("SHA-512");

  private String name;

  private DigestMessageType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
