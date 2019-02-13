package com.magic.platform.dubbo.provider.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.provider.business.mapper.custom.dao.DubboMenuMapper;
import com.magic.platform.core.jwt.Token;
import com.magic.platform.dubbo.dto.MenuDto;
import com.magic.platform.dubbo.service.IMenuService;
import io.jsonwebtoken.Claims;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 21:21
 * @Modified By:
 */
@Service
public class MenuServiceImpl implements IMenuService {

  @Autowired
  private DubboMenuMapper dubboMenuMapper;

  /**
   * 根据 accessToken，平台id 查询可操作菜单
   * @param platId
   * @param accessToken
   * @return
   */
  @Override
  public List<MenuDto> selectAllGrantedMenus(String platId, String accessToken) throws CustomException {

    Claims claims = Token.parseAccessToken2Claims(accessToken);
    String userName = claims.getSubject();

    return dubboMenuMapper.selectAllGrantedMenus(platId, userName);
  }
}
