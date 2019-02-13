package com.magic.platform.dubbo.provider.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.dto.UserDto;
import com.magic.platform.dubbo.provider.business.mapper.custom.dao.DubboUserMapper;
import com.magic.platform.dubbo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 20:20
 * @Modified By:
 */
@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private DubboUserMapper dubboUserMapper;

  @Override
  public UserDto getUserDtoByAccessToken(String accessToken) throws CustomException {
    return null;
  }
}
