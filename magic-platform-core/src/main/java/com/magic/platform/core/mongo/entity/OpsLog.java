package com.magic.platform.core.mongo.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-15 17:17
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ops_log")
public class OpsLog {

  @Id
  private ObjectId id;

  /**
   * 操作账号
   */
  @Field("user_name")
  private String userName;

  /**
   * 操作人
   */
  @Field("real_name")
  private String realName;

  /**
   * 请求路径
   */
  @Field("path")
  private String path;

  /**
   * 请求ip
   */
  @Field("ip")
  private String ip;

  /**
   * 请求环境信息
   */
  @Field("environment")
  private String environment;

  /**
   * 请求时间
   */
  @Field("create_time")
  private Date createTime;

  /**
   * 平台id
   */
  @Field("plat_id")
  private String platId;

  /**
   * 平台名称
   */
  @Field("plat_name")
  private String platName;

  /**
   * 平台版本
   */
  @Field("plat_version")
  private String platVersion;

  /**
   * 操作名称
   */
  @Field("ops_name")
  private String opsName;

  /**
   * 操作类型
   */
  @Field("ops_type")
  private String opsType;

}
