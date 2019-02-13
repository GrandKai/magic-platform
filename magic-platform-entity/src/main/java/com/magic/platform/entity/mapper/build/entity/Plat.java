package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class Plat {
    /**
     * 平台id
     */
    @Id
    private String id;

    /**
     * 平台名称
     */
    private String name;

    /**
     * 平台描述
     */
    private String description;

    /**
     * 平台url地址
     */
    private String url;

    /**
     * 平台图片
     */
    private String image;

    /**
     * 平台版本
     */
    private String version;

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
     * 是否删除（1：是，0：否）
     */
    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 是否启用（1：是，0：否）
     */
    @Column(name = "is_enabled")
    private String isEnabled;

    /**
     * 获取平台id
     *
     * @return id - 平台id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置平台id
     *
     * @param id 平台id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取平台名称
     *
     * @return name - 平台名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置平台名称
     *
     * @param name 平台名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取平台描述
     *
     * @return description - 平台描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置平台描述
     *
     * @param description 平台描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取平台url地址
     *
     * @return url - 平台url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置平台url地址
     *
     * @param url 平台url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取平台图片
     *
     * @return image - 平台图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置平台图片
     *
     * @param image 平台图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取平台版本
     *
     * @return version - 平台版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置平台版本
     *
     * @param version 平台版本
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
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

    /**
     * 获取是否启用（1：是，0：否）
     *
     * @return is_enabled - 是否启用（1：是，0：否）
     */
    public String getIsEnabled() {
        return isEnabled;
    }

    /**
     * 设置是否启用（1：是，0：否）
     *
     * @param isEnabled 是否启用（1：是，0：否）
     */
    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled == null ? null : isEnabled.trim();
    }
}