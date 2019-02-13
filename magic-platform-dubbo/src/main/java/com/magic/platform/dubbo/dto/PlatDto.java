package com.magic.platform.dubbo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 19:19
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatDto implements Serializable {
  /**
   * 平台id
   */
  private String id;

  /**
   * 平台名称
   */
  private String name;

  /**
   * 平台描述
   */
  private String description;

  /**
   * 平台url地址
   */
  private String url;

  /**
   * 平台图片
   */
  private String image;

  /**
   * 平台版本
   */
  private String version;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 排序字段
   */
  private Short sortNumber;

  /**
   * 是否删除（1：是，0：否）
   */
  private String isDeleted;

  /**
   * 是否启用（1：是，0：否）
   */
  private String isEnabled;
}
