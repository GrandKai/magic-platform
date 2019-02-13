package com.magic.platform.dubbo.provider.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.magic.platform.core.exception.CustomException;
import com.magic.platform.dubbo.provider.business.mapper.custom.dao.DubboPermissionMapper;
import com.magic.platform.dubbo.service.IPermissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 17:17
 * @Modified By:
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

  @Autowired
  private DubboPermissionMapper dubboPermissionMapper;

  @Override
  public List<String> selectAllGrantedPermissions(String userName) throws CustomException {
    return dubboPermissionMapper.selectAllGrantedPermissions(userName);
  }
}
