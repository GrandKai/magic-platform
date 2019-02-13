package com.magic.platform.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-20 09:09
 * @Modified By:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Validated
@JsonInclude(value = Include.NON_NULL)
public class PageModel {

  /**
   * 分页页码
   */
  private Integer pageNum;

  /**
   * 页面大小
   */
  private Integer pageSize;
}
