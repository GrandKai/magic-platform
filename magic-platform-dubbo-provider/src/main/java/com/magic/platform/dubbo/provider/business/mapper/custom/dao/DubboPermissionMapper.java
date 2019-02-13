package com.magic.platform.dubbo.provider.business.mapper.custom.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 17:17
 * @Modified By:
 */
public interface DubboPermissionMapper {

  List<String> selectAllGrantedPermissions(@Param("userName") String userName);
}
