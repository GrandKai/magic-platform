package com.magic.platform.dubbo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto implements Serializable {
    /**
     * 菜单id
     */
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 所属平台
     */
    private String platId;

    /**
     * 父菜单id
     */
    private String parentId;

    /**
     * 菜单路由（页面跳转地址）
     */
    private String router;

    /**
     * 菜单图标
     */
    private String image;

    /**
     * 是否是叶子节点（1：是，0：否）
     */
    private String isLeaf;

    /**
     * 是否删除（1：是，0：否）
     */
    private String isDeleted;

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
     * 是否显示（1：是，0：否）
     */
    private String isShow;
}