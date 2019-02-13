package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    private String id;

    /**
     * 用户账号（登录
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 是否启用（1：是，0：否）
     */
    @Column(name = "is_enabled")
    private String isEnabled;

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
     * 获取用户账号（登录
     *
     * @return name - 用户账号（登录
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户账号（登录
     *
     * @param name 用户账号（登录
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
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
}