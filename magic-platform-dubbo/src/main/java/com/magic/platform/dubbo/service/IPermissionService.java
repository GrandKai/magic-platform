package com.magic.platform.dubbo.service;

import com.magic.platform.core.exception.CustomException;
import java.util.List;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 17:17
 * @Modified By:
 */
public interface IPermissionService {

  /**
   * 获取所有授予的操作 url 信息
   * @param userName
   * @return
   */
  List<String> selectAllGrantedPermissions(String userName) throws CustomException;
}
