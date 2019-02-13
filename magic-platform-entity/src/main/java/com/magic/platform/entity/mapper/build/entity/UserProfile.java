package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_profile")
public class UserProfile {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 性别（1：男，2：女）
     */
    private String gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 个人头像
     */
    private String photo;

    /**
     * 二维码
     */
    @Column(name = "qr_code")
    private String qrCode;

    /**
     * 个人描述
     */
    private String description;

    /**
     * 出生日期
     */
    private Date birthdate;

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
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取性别（1：男，2：女）
     *
     * @return gender - 性别（1：男，2：女）
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别（1：男，2：女）
     *
     * @param gender 性别（1：男，2：女）
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取个人头像
     *
     * @return photo - 个人头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置个人头像
     *
     * @param photo 个人头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取二维码
     *
     * @return qr_code - 二维码
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * 设置二维码
     *
     * @param qrCode 二维码
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    /**
     * 获取个人描述
     *
     * @return description - 个人描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置个人描述
     *
     * @param description 个人描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取出生日期
     *
     * @return birthdate - 出生日期
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * 设置出生日期
     *
     * @param birthdate 出生日期
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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