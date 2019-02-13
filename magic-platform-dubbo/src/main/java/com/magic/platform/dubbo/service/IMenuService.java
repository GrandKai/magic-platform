package com.magic.platform.dubbo.service;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.dto.MenuDto;
import java.util.List;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 21:21
 * @Modified By:
 */
public interface IMenuService {

  List<MenuDto> selectAllGrantedMenus(String platId, String accessToken) throws CustomException;
}
