package com.magic.platform.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-17 15:15
 * @Modified By:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestModel<T> {

  /**
   * accessToken
   */
  private String accessToken;

  /**
   * refreshToken
   */
  private String refreshToken;

  /**
   * 版本号
   */
  private String version;

  /**
   * 请求内容
   */
  private T content;

  /**
   * 分页模型
   */
  private PageModel page;
}
