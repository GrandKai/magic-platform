//package com.magic.platform.core.exception;
//
//import lombok.NonNull;
//import org.springframework.security.core.AuthenticationException;
//
///**
// * @Author: zyn
// * @Description:
// * @Date: Created in 2018-09-07 09:09
// * @Modified By:
// */
//public class CustomAuthenticationException extends AuthenticationException {
//
//  @NonNull
//  private Integer code;
//  @NonNull
//  private String message;
//
//  public CustomAuthenticationException(String msg, Throwable t) {
//    super(msg, t);
//  }
//
//  public CustomAuthenticationException(String msg) {
//    super(msg);
//  }
//
//  public CustomAuthenticationException(CustomException exception) {
//    super(exception.getMessage());
//
//    this.code = exception.getCode();
//    this.message = exception.getMessage();
//  }
//
//  public Integer getCode() {
//    return code;
//  }
//
//  public void setCode(Integer code) {
//    this.code = code;
//  }
//
//  @Override
//  public String getMessage() {
//    return message;
//  }
//
//  public void setMessage(String message) {
//    this.message = message;
//  }
//}
