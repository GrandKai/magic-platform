package com.magic.platform.dubbo.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Administrator
 * @Description:
 * @Date: Created in 2019-06-04 20:20
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto implements Serializable {

  private String id;

  /**
   * 菜单id
   */
  private String menuId;

  private String name;

  /**
   * 操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）
   */
  private String type;

  /**
   * 排序字段
   */
  private Short sortNumber;

  /**
   * 按钮对应的 url 链接集合
   */
  private List<PermissionDto> permissionList;
}
