package com.magic.platform.dubbo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 17:17
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto implements Serializable {

  private String id;

  private String name;

  /**
   * 访问许可地址（即：api url 地址）
   */
  private String url;

  /**
   * 所属操作
   */
  private String operationId;

  private Date createTime;

  private Date updateTime;

  private Short sortNumber;
}
