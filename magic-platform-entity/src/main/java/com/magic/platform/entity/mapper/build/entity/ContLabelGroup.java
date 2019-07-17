package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cont_label_group")
public class ContLabelGroup {
    /**
     * 标签组id
     */
    @Id
    private String id;

    /**
     * 标签组名称
     */
    private String name;

    /**
     * 排序字段
     */
    @Column(name = "sort_number")
    private Short sortNumber;

    /**
     * 标签组描述
     */
    private String description;

    /**
     * 是否删除（默认未删除）
     */
    @Column(name = "is_deleted")
    private String isDeleted;

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
     * 获取标签组id
     *
     * @return id - 标签组id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置标签组id
     *
     * @param id 标签组id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取标签组名称
     *
     * @return name - 标签组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置标签组名称
     *
     * @param name 标签组名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取标签组描述
     *
     * @return description - 标签组描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置标签组描述
     *
     * @param description 标签组描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取是否删除（默认未删除）
     *
     * @return is_deleted - 是否删除（默认未删除）
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除（默认未删除）
     *
     * @param isDeleted 是否删除（默认未删除）
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
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
}