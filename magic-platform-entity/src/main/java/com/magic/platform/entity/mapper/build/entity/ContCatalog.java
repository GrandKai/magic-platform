package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cont_catalog")
public class ContCatalog {
    /**
     * 栏目id
     */
    @Id
    private String id;

    /**
     * 栏目名称
     */
    private String name;

    /**
     * 路由地址（页面跳转地址）
     */
    private String router;

    /**
     * 栏目图片
     */
    private String image;

    /**
     * 叶子深度
     */
    private String level;

    /**
     * 排序字段
     */
    @Column(name = "sort_number")
    private Short sortNumber;

    /**
     * 描述
     */
    private String description;

    /**
     * 前端是否显示
     */
    @Column(name = "is_show")
    private String isShow;

    /**
     * 是否删除（默认0：未删除）
     */
    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 父栏目id
     */
    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取栏目id
     *
     * @return id - 栏目id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置栏目id
     *
     * @param id 栏目id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取栏目名称
     *
     * @return name - 栏目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置栏目名称
     *
     * @param name 栏目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取路由地址（页面跳转地址）
     *
     * @return router - 路由地址（页面跳转地址）
     */
    public String getRouter() {
        return router;
    }

    /**
     * 设置路由地址（页面跳转地址）
     *
     * @param router 路由地址（页面跳转地址）
     */
    public void setRouter(String router) {
        this.router = router == null ? null : router.trim();
    }

    /**
     * 获取栏目图片
     *
     * @return image - 栏目图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置栏目图片
     *
     * @param image 栏目图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取叶子深度
     *
     * @return level - 叶子深度
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置叶子深度
     *
     * @param level 叶子深度
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取前端是否显示
     *
     * @return is_show - 前端是否显示
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置前端是否显示
     *
     * @param isShow 前端是否显示
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * 获取是否删除（默认0：未删除）
     *
     * @return is_deleted - 是否删除（默认0：未删除）
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除（默认0：未删除）
     *
     * @param isDeleted 是否删除（默认0：未删除）
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 获取父栏目id
     *
     * @return parent_id - 父栏目id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父栏目id
     *
     * @param parentId 父栏目id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
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