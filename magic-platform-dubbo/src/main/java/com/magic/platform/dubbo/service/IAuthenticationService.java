package com.magic.platform.dubbo.service;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.dto.AuthenticationDto;
import com.magic.platform.dubbo.dto.TokenDto;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 20:20
 * @Modified By:
 */
public interface IAuthenticationService {

  AuthenticationDto getAuthenticationToken(String username, String password) throws CustomException;

  void modifyPassword(String accessToken, String oldPassword, String newPassword) throws CustomException;

  TokenDto refreshAccessToken(String refreshToken) throws CustomException;
}
