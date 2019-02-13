package com.magic.platform.entity.mapper.build.entity;

import javax.persistence.*;

@Table(name = "user_account")
public class UserAccount {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 付款密码
     */
    @Column(name = "pay_password")
    private String payPassword;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取付款密码
     *
     * @return pay_password - 付款密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 设置付款密码
     *
     * @param payPassword 付款密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }
}