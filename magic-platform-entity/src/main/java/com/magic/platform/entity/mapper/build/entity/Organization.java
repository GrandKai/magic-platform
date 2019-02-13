package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class Organization {
    /**
     * 组织机构id
     */
    @Id
    private String id;

    /**
     * 组织机构名称
     */
    private String name;

    /**
     * 父节点id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 组织结构目录深度
     */
    private String level;

    /**
     * 是否是叶子节点
     */
    @Column(name = "is_leaf")
    private String isLeaf;

    /**
     * 排序字段
     */
    @Column(name = "sort_number")
    private Short sortNumber;

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
     * 是否删除（1：是，0：否）
     */
    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 获取组织机构id
     *
     * @return id - 组织机构id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置组织机构id
     *
     * @param id 组织机构id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取组织机构名称
     *
     * @return name - 组织机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织机构名称
     *
     * @param name 组织机构名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取父节点id
     *
     * @return parent_id - 父节点id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父节点id
     *
     * @param parentId 父节点id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取组织结构目录深度
     *
     * @return level - 组织结构目录深度
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置组织结构目录深度
     *
     * @param level 组织结构目录深度
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 获取是否是叶子节点
     *
     * @return is_leaf - 是否是叶子节点
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否是叶子节点
     *
     * @param isLeaf 是否是叶子节点
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
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
     * 获取是否删除（1：是，0：否）
     *
     * @return is_deleted - 是否删除（1：是，0：否）
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除（1：是，0：否）
     *
     * @param isDeleted 是否删除（1：是，0：否）
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}