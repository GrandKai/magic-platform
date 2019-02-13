package com.magic.platform.dubbo.service;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.dto.UserDto;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 19:19
 * @Modified By:
 */
public interface IUserService {

  UserDto getUserDtoByAccessToken(String accessToken) throws CustomException;
}
