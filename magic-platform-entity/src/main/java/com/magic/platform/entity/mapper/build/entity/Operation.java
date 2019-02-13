package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class Operation {
    @Id
    private String id;

    /**
     * 菜单id
     */
    @Column(name = "menu_id")
    private String menuId;

    private String name;

    /**
     * 操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）
     */
    private String type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 排序字段
     */
    @Column(name = "sort_number")
    private Short sortNumber;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取菜单id
     *
     * @return menu_id - 菜单id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）
     *
     * @return type - 操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）
     *
     * @param type 操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取排序字段
     *
     * @return sort_number - 排序字段
     */
    public Short getSortNumber() {
        return sortNumber;
    }

    /**
     * 设置排序字段
     *
     * @param sortNumber 排序字段
     */
    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }
}