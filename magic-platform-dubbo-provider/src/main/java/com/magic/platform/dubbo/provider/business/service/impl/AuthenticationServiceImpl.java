package com.magic.platform.dubbo.provider.business.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.magic.platform.core.constant.Constant;
import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.exception.ExceptionEnum;
import com.magic.platform.core.jwt.Token;
import com.magic.platform.dubbo.dto.AuthenticationDto;
import com.magic.platform.dubbo.dto.TokenDto;
import com.magic.platform.dubbo.dto.UserDto;
import com.magic.platform.dubbo.service.IAuthenticationService;
import com.magic.platform.encrypt.enumeration.DigestMessageType;
import com.magic.platform.entity.mapper.build.dao.UserMapper;
import com.magic.platform.entity.mapper.build.entity.User;
import com.magic.platform.support.properties.FrameworkProperties;
import com.magic.platform.support.properties.RedisProperties;
import com.magic.platform.util.DigestMessageUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 20:20
 * @Modified By:
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private FrameworkProperties frameworkProperties;
  @Autowired
  private RedisProperties redisProperties;

  /**
   * 登录获取账号，token等信息
   * @param username
   * @param password
   * @return
   */
  @Override
  public AuthenticationDto getAuthenticationToken(String username, String password) throws CustomException {

    User param = new User();
    param.setName(username);

    User user = userMapper.selectOne(param);

    if (user == null) {
      // 无效用户名
      throw ExceptionEnum.INVALID_USERNAME.getException();
    }

    this.checkPassword(user.getPassword(), password);
    this.checkUserStatus(user);

    Claims claims = new DefaultClaims();
    claims.setSubject(username);

    String accessToken = Token.generateAccessToken(claims, redisProperties.getValidTimeSecondAccessToken());
    String refreshToken = Token.generateRefreshToken(claims, redisProperties.getValidTimeSecondRefreshToken());

    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);

    AuthenticationDto dto = new AuthenticationDto();
    dto.setAccessToken(accessToken);
    dto.setRefreshToken(refreshToken);
    dto.setUserDto(userDto);
    dto.setVersion(frameworkProperties.getVersion());

    return dto;
  }

  /**
   * 修改密码 FIXME: 将 accessToken 置位无效
   * @param accessToken
   * @param oldPassword
   * @param newPassword
   */
  @Override
  public void modifyPassword(String accessToken, String oldPassword, String newPassword) throws CustomException {

    Claims claims = Token.parseAccessToken2Claims(accessToken);
    String username = claims.getSubject();

    // 1. 根据旧密码获取用户
    String encodeOldPassword = this.getEncodePassword(oldPassword);

    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(encodeOldPassword)) {
      throw ExceptionEnum.INVALID_ACCOUNT_OR_PASSWORD.getException();
    }

    // 2. 比较新旧密码
    String encodedNewPassword = this.getEncodePassword(newPassword);

    if (encodeOldPassword.equals(encodedNewPassword)) {
      throw ExceptionEnum.NEW_PASSWORD_EQUAL_OLD_PASSWORD.getException();
    }

    User param = new User();
    param.setName(username);
    param.setPassword(encodeOldPassword);

    User entity = userMapper.selectOne(param);
    if (entity == null) {
      throw ExceptionEnum.INVALID_ACCOUNT_OR_PASSWORD.getException();
    }

    User user = new User();
    user.setId(entity.getId());
    user.setPassword(encodedNewPassword);
    user.setUpdateTime(new Date());
    userMapper.updateByPrimaryKeySelective(user);
  }

  /**
   * 根据 refreshToken 重新剩个 AccessToken
   * @param refreshToken
   * @return
   */
  @Override
  public TokenDto refreshAccessToken(String refreshToken) throws CustomException {

    Claims claims = Token.parseRefreshToken2Claims(refreshToken);
    String username = claims.getSubject();

    Claims payload = new DefaultClaims();
    payload.setSubject(username);

    String newAccessToken = Token.generateAccessToken(payload, redisProperties.getValidTimeSecondAccessToken());

    TokenDto tokenDTO = new TokenDto();
    tokenDTO.setAccessToken(newAccessToken);
    tokenDTO.setRefreshToken(refreshToken);

    return tokenDTO;
  }
  /**
   * 密码校验
   * @param systemPwd 系统保存密码
   * @param inputPwd 输入密码
   */
  private void checkPassword(String systemPwd, String inputPwd) {
    String encodePwd = "";
    try {
      encodePwd = DigestMessageUtil.getInstance().encodeWithBASE64(inputPwd, DigestMessageType.MD5);
    } catch (Exception e) {
      throw ExceptionEnum.INVALID_PASSWORD.getException();
    }

    if (!StringUtils.equals(systemPwd, encodePwd)) {
      throw ExceptionEnum.INVALID_PASSWORD.getException();
    }
  }

  /**
   * 检测账号删除、禁用状态
   * @param user
   */
  private void checkUserStatus(User user) {
    if (Constant.ONE.equals(user.getIsDeleted())) {
      throw ExceptionEnum.ACCOUNT_DELETED.getException();
    }

    if (!Constant.ONE.equals(user.getIsEnabled())) {
      throw ExceptionEnum.ACCOUNT_DISABLED.getException();
    }
  }

  /**
   * 获取加密密码
   * @param rawPassword 未加密密码
   * @return 加密密码
   */
  private String getEncodePassword(String rawPassword) {

    String encodePassword = null;
    try {
      encodePassword = DigestMessageUtil.getInstance().encodeWithBASE64(rawPassword, DigestMessageType.MD5);
    } catch (Exception e) {
      throw ExceptionEnum.INVALID_PASSWORD.getException();
    }

    return encodePassword;
  }
}
