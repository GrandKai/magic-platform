package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class Menu {
    /**
     * 菜单id
     */
    @Id
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 所属平台
     */
    @Column(name = "plat_id")
    private String platId;

    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
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
    @Column(name = "is_leaf")
    private String isLeaf;

    /**
     * 是否删除（1：是，0：否）
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
     * 排序字段
     */
    @Column(name = "sort_number")
    private Short sortNumber;

    /**
     * 是否显示（1：是，0：否）
     */
    @Column(name = "is_show")
    private String isShow;

    /**
     * 获取菜单id
     *
     * @return id - 菜单id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置菜单id
     *
     * @param id 菜单id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取父菜单id
     *
     * @return parent_id - 父菜单id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单id
     *
     * @param parentId 父菜单id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取菜单路由（页面跳转地址）
     *
     * @return router - 菜单路由（页面跳转地址）
     */
    public String getRouter() {
        return router;
    }

    /**
     * 设置菜单路由（页面跳转地址）
     *
     * @param router 菜单路由（页面跳转地址）
     */
    public void setRouter(String router) {
        this.router = router == null ? null : router.trim();
    }

    /**
     * 获取菜单图标
     *
     * @return image - 菜单图标
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置菜单图标
     *
     * @param image 菜单图标
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取是否是叶子节点（1：是，0：否）
     *
     * @return is_leaf - 是否是叶子节点（1：是，0：否）
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否是叶子节点（1：是，0：否）
     *
     * @param isLeaf 是否是叶子节点（1：是，0：否）
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
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
     * 获取是否显示（1：是，0：否）
     *
     * @return is_show - 是否显示（1：是，0：否）
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示（1：是，0：否）
     *
     * @param isShow 是否显示（1：是，0：否）
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }
}