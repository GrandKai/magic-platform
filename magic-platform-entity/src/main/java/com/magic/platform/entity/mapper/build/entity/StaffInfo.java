package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "staff_info")
public class StaffInfo {
    /**
     * 员工id
     */
    @Id
    private String id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 所属组织机构
     */
    @Column(name = "organization_id")
    private String organizationId;

    /**
     * 所属组织机构名称
     */
    @Column(name = "organizaiton_name")
    private String organizaitonName;

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
     * 是否启用（1：启用，0：未启用）
     */
    @Column(name = "is_enabled")
    private String isEnabled;

    /**
     * 获取员工id
     *
     * @return id - 员工id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置员工id
     *
     * @param id 员工id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取员工姓名
     *
     * @return name - 员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置员工姓名
     *
     * @param name 员工姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取所属组织机构
     *
     * @return organization_id - 所属组织机构
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置所属组织机构
     *
     * @param organizationId 所属组织机构
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    /**
     * 获取所属组织机构名称
     *
     * @return organizaiton_name - 所属组织机构名称
     */
    public String getOrganizaitonName() {
        return organizaitonName;
    }

    /**
     * 设置所属组织机构名称
     *
     * @param organizaitonName 所属组织机构名称
     */
    public void setOrganizaitonName(String organizaitonName) {
        this.organizaitonName = organizaitonName == null ? null : organizaitonName.trim();
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
     * 获取是否启用（1：启用，0：未启用）
     *
     * @return is_enabled - 是否启用（1：启用，0：未启用）
     */
    public String getIsEnabled() {
        return isEnabled;
    }

    /**
     * 设置是否启用（1：启用，0：未启用）
     *
     * @param isEnabled 是否启用（1：启用，0：未启用）
     */
    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled == null ? null : isEnabled.trim();
    }
}