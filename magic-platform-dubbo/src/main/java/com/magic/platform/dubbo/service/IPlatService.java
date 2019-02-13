package com.magic.platform.dubbo.service;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.dto.PlatDto;
import java.util.List;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 19:19
 * @Modified By:
 */
public interface IPlatService {

  /**
   * 根据 accessToken 获取授权平台列表
   * @param accessToken
   * @return
   */
  List<PlatDto> selectAllGrantedPlats(String accessToken) throws CustomException;
}
