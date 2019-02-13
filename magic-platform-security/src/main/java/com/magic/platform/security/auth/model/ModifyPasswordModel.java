package com.magic.platform.security.auth.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 09:09
 * @Modified By:
 */
@Setter
@Getter
public class ModifyPasswordModel {

  private String oldPassword;
  private String newPassword;

}
