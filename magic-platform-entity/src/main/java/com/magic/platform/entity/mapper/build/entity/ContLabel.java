package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cont_label")
public class ContLabel {
    /**
     * 标签id
     */
    @Id
    private String id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 所属标签组id
     */
    @Column(name = "group_id")
    private String groupId;

    @Column(name = "sort_number")
    private Short sortNumber;

    /**
     * 是否删除（默认 0 未删除）
     */
    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 是否显示（1，显示，0，不显示）

     */
    @Column(name = "is_show")
    private String isShow;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取标签id
     *
     * @return id - 标签id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置标签id
     *
     * @param id 标签id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取标签名称
     *
     * @return name - 标签名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置标签名称
     *
     * @param name 标签名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取所属标签组id
     *
     * @return group_id - 所属标签组id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置所属标签组id
     *
     * @param groupId 所属标签组id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * @return sort_number
     */
    public Short getSortNumber() {
        return sortNumber;
    }

    /**
     * @param sortNumber
     */
    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }

    /**
     * 获取是否删除（默认 0 未删除）
     *
     * @return is_deleted - 是否删除（默认 0 未删除）
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除（默认 0 未删除）
     *
     * @param isDeleted 是否删除（默认 0 未删除）
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 获取是否显示（1，显示，0，不显示）

     *
     * @return is_show - 是否显示（1，显示，0，不显示）

     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示（1，显示，0，不显示）

     *
     * @param isShow 是否显示（1，显示，0，不显示）

     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}