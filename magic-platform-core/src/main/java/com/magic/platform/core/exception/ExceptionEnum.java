package com.magic.platform.core.exception;

import lombok.Getter;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-17 15:15
 * @Modified By:
 */
@Getter
public enum ExceptionEnum {

  /**
   * accessToken 相关
   */
  ACCESS_TOKEN_NOT_NULL(new CustomException(ExceptionCode.ACCESS_TOKEN_IS_NULL.getKey(), ExceptionCode.ACCESS_TOKEN_IS_NULL.getValue())),
  ACCESS_TOKEN_INVALID(new CustomException(ExceptionCode.ACCESS_TOKEN_INVALID.getKey(), ExceptionCode.ACCESS_TOKEN_INVALID.getValue())),
  ACCESS_TOKEN_EXPIRED(new CustomException(ExceptionCode.ACCESS_TOKEN_EXPIRED.getKey(), ExceptionCode.ACCESS_TOKEN_EXPIRED.getValue())),
  ACCESS_TOKEN_PARSED_EXCEPTION(new CustomException(ExceptionCode.ACCESS_TOKEN_PARSED_EXCEPTION.getKey(), ExceptionCode.ACCESS_TOKEN_PARSED_EXCEPTION.getValue())),

  ACCESS_TOKEN_INTERPOLATED(new CustomException(ExceptionCode.ACCESS_TOKEN_INTERPOLATED.getKey(), ExceptionCode.ACCESS_TOKEN_INTERPOLATED.getValue())),
  ACCESS_TOKEN_INVALID_SIGN(new CustomException(ExceptionCode.ACCESS_TOKEN_INVALID_SIGN.getKey(), ExceptionCode.ACCESS_TOKEN_INVALID_SIGN.getValue())),
  /**
   * refreshToken 相关
   */
  REFRESH_TOKEN_NOT_NULL(new CustomException(ExceptionCode.REFRESH_TOKEN_IS_NULL.getKey(), ExceptionCode.REFRESH_TOKEN_IS_NULL.getValue())),
  REFRESH_TOKEN_INVALID(new CustomException(ExceptionCode.REFRESH_TOKEN_INVALID.getKey(), ExceptionCode.REFRESH_TOKEN_INVALID.getValue())),
  REFRESH_TOKEN_EXPIRED(new CustomException(ExceptionCode.REFRESH_TOKEN_EXPIRED.getKey(), ExceptionCode.REFRESH_TOKEN_EXPIRED.getValue())),
  REFRESH_TOKEN_PARSED_EXCEPTION(new CustomException(ExceptionCode.REFRESH_TOKEN_PARSED_EXCEPTION.getKey(), ExceptionCode.REFRESH_TOKEN_PARSED_EXCEPTION.getValue())),

  REFRESH_TOKEN_INTERPOLATED(new CustomException(ExceptionCode.REFRESH_TOKEN_INTERPOLATED.getKey(), ExceptionCode.REFRESH_TOKEN_INTERPOLATED.getValue())),
  REFRESH_TOKEN_INVALID_SIGN(new CustomException(ExceptionCode.REFRESH_TOKEN_INVALID_SIGN.getKey(), ExceptionCode.REFRESH_TOKEN_INVALID_SIGN.getValue())),


  /**
   * 认证相关
   */
  ACCESS_DENIED(new CustomException(ExceptionCode.ACCESS_DENIED.getKey(), ExceptionCode.ACCESS_DENIED.getValue())),
  AUTHENTICATION_FAILED(new CustomException(ExceptionCode.AUTHENTICATION_FAILED.getKey(), ExceptionCode.AUTHENTICATION_FAILED.getValue())),

  USERNAME_NOT_FOUND(new CustomException(ExceptionCode.USERNAME_NOT_FOUND.getKey(), ExceptionCode.USERNAME_NOT_FOUND.getValue())),
  AUTHENTICATION_IS_NULL(new CustomException(ExceptionCode.AUTHENTICATION_IS_NULL.getKey(), ExceptionCode.AUTHENTICATION_IS_NULL.getValue())),

  RESPONSE_EXCEPTION(new CustomException(ExceptionCode.RESPONSE_EXCEPTION.getKey(), ExceptionCode.RESPONSE_EXCEPTION.getValue())),
  INVALID_PASSWORD(new CustomException(ExceptionCode.INVALID_PASSWORD.getKey(), ExceptionCode.INVALID_PASSWORD.getValue())),
  INVALID_USERNAME(new CustomException(ExceptionCode.INVALID_USERNAME.getKey(), ExceptionCode.INVALID_USERNAME.getValue())),
  ACCOUNT_DELETED(new CustomException(ExceptionCode.ACCOUNT_DELETED.getKey(), ExceptionCode.ACCOUNT_DELETED.getValue())),
  ACCOUNT_DISABLED(new CustomException(ExceptionCode.ACCOUNT_DISABLED.getKey(), ExceptionCode.ACCOUNT_DISABLED.getValue())),

  INVALID_ACCOUNT_OR_PASSWORD(new CustomException(ExceptionCode.INVALID_ACCOUNT_OR_PASSWORD.getKey(), ExceptionCode.INVALID_ACCOUNT_OR_PASSWORD.getValue())),
  NEW_PASSWORD_IS_NULL(new CustomException(ExceptionCode.NEW_PASSWORD_IS_NULL.getKey(), ExceptionCode.NEW_PASSWORD_IS_NULL.getValue())),
  REPEAT_PASSWORD_NOT_EQUAL(new CustomException(ExceptionCode.REPEAT_PASSWORD_NOT_EQUAL.getKey(), ExceptionCode.REPEAT_PASSWORD_NOT_EQUAL.getValue())),
  NEW_PASSWORD_EQUAL_OLD_PASSWORD(new CustomException(ExceptionCode.NEW_PASSWORD_EQUAL_OLD_PASSWORD.getKey(), ExceptionCode.NEW_PASSWORD_EQUAL_OLD_PASSWORD.getValue())),

  ENCRYPTION_PASSWORD_ERROR(new CustomException(ExceptionCode.ENCRYPTION_PASSWORD_ERROR.getKey(), ExceptionCode.ENCRYPTION_PASSWORD_ERROR.getValue())),
  DECRYPTION_PASSWORD_ERROR(new CustomException(ExceptionCode.DECRYPTION_PASSWORD_ERROR.getKey(), ExceptionCode.DECRYPTION_PASSWORD_ERROR.getValue())),

  ;
  private CustomException exception;

  ExceptionEnum(CustomException exception) {
    this.exception = exception;
  }


}
