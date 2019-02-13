package com.magic.platform.dubbo.provider.business.mapper.custom.dao;

import com.magic.platform.dubbo.dto.MenuDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 21:21
 * @Modified By:
 */
public interface DubboMenuMapper {

  List<MenuDto> selectAllGrantedMenus(@Param("platId") String platId, @Param("userName") String userName);
}
