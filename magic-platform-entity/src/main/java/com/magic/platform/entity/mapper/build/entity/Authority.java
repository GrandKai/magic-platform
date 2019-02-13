package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class Authority {
    /**
     * 权限id
     */
    @Id
    private String id;

    /**
     * 所属平台
     */
    @Column(name = "plat_id")
    private String platId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

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
     * 获取权限id
     *
     * @return id - 权限id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置权限id
     *
     * @param id 权限id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取所属平台
     *
     * @return plat_id - 所属平台
     */
    public String getPlatId() {
        return platId;
    }

    /**
     * 设置所属平台
     *
     * @param platId 所属平台
     */
    public void setPlatId(String platId) {
        this.platId = platId == null ? null : platId.trim();
    }

    /**
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限描述
     *
     * @return description - 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置权限描述
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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