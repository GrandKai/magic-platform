package com.magic.platform.core.exception;

import javafx.util.Pair;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-08-30 15:15
 * @Modified By:
 */
public interface ExceptionCode {

  /**
   * accessToken 相关
   */
  Pair<Integer, String> ACCESS_TOKEN_IS_NULL = new Pair<>(1001, "[accessToken]不能为空!");
  Pair<Integer, String> ACCESS_TOKEN_INVALID = new Pair<>(1002, "无效的[accessToken]!");
  Pair<Integer, String> ACCESS_TOKEN_EXPIRED = new Pair<>(1003, "过期的[accessToken]!");
  Pair<Integer, String> ACCESS_TOKEN_INVALID_SIGN = new Pair<>(1004, "无效的[accessToken]签名！");
  Pair<Integer, String> ACCESS_TOKEN_PARSED_EXCEPTION = new Pair<>(1005, "无效的[accessToken]的jwt!");
  Pair<Integer, String> ACCESS_TOKEN_INTERPOLATED = new Pair<>(1006, "被篡改的[accessToken]!");

  /**
   * refreshToken 相关
   */
  Pair<Integer, String> REFRESH_TOKEN_IS_NULL = new Pair<>(1011, "[refreshToken]不能为空!");
  Pair<Integer, String> REFRESH_TOKEN_INVALID = new Pair<>(1012, "无效的[refreshToken]!");
  Pair<Integer, String> REFRESH_TOKEN_EXPIRED = new Pair<>(1013, "过期的[refreshToken]!");
  Pair<Integer, String> REFRESH_TOKEN_INVALID_SIGN = new Pair<>(1014, "无效的[refreshToken]签名！");
  Pair<Integer, String> REFRESH_TOKEN_PARSED_EXCEPTION = new Pair<>(1015, "无效的[refreshToken]的jwt!");
  Pair<Integer, String> REFRESH_TOKEN_INTERPOLATED = new Pair<>(1016, "被篡改的[refreshToken]!");

  /**
   * 认证相关
   */
  Pair<Integer, String> ACCESS_DENIED = new Pair<>(1007, "没有权限，拒绝访问!");
  Pair<Integer, String> AUTHENTICATION_FAILED = new Pair<>(1008, "认证失败!");

  /**
   * 认证用户信息相关
   */
  Pair<Integer, String> USERNAME_NOT_FOUND = new Pair<>(2001, "用户未找到!");
  Pair<Integer, String> AUTHENTICATION_IS_NULL = new Pair<>(2002, "未获取到认证用户信息!");
  Pair<Integer, String> INVALID_USERNAME = new Pair<>(2003, "无效用户名!");
  Pair<Integer, String> INVALID_PASSWORD = new Pair<>(2004, "无效密码!");
  Pair<Integer, String> ACCOUNT_DELETED = new Pair<>(2005, "账号已被删除!");
  Pair<Integer, String> ACCOUNT_DISABLED = new Pair<>(2006, "账号已被禁用!");


  Pair<Integer, String> INVALID_ACCOUNT_OR_PASSWORD = new Pair<>(2007, "无效的账号或密码!");
  Pair<Integer, String> NEW_PASSWORD_IS_NULL = new Pair<>(2008, "新密码不能为空!");
  Pair<Integer, String> REPEAT_PASSWORD_NOT_EQUAL = new Pair<>(2009, "两次输入密码不一致!");
  Pair<Integer, String> NEW_PASSWORD_EQUAL_OLD_PASSWORD = new Pair<>(2010, "新密码与旧密码相同!");

  Pair<Integer, String> ENCRYPTION_PASSWORD_ERROR = new Pair<>(2011, "密码加密异常!");
  Pair<Integer, String> DECRYPTION_PASSWORD_ERROR = new Pair<>(2012, "密码解密异常!");

  Pair<Integer, String> RESPONSE_EXCEPTION = new Pair<>(3001, "响应异常!");

}