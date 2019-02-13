package com.magic.platform.entity.mapper.build.entity;

import javax.persistence.*;

@Table(name = "user_address")
public class UserAddress {
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 收件人姓名
     */
    private String recipient;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 标签（家，公司，学校等）
     */
    private String label;

    /**
     * 是否是默认收货地址（1：是，0：否）
     */
    @Column(name = "is_default")
    private String isDefault;

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
     * 获取收件人姓名
     *
     * @return recipient - 收件人姓名
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * 设置收件人姓名
     *
     * @param recipient 收件人姓名
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取区
     *
     * @return district - 区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区
     *
     * @param district 区
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取标签（家，公司，学校等）
     *
     * @return label - 标签（家，公司，学校等）
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置标签（家，公司，学校等）
     *
     * @param label 标签（家，公司，学校等）
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * 获取是否是默认收货地址（1：是，0：否）
     *
     * @return is_default - 是否是默认收货地址（1：是，0：否）
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否是默认收货地址（1：是，0：否）
     *
     * @param isDefault 是否是默认收货地址（1：是，0：否）
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }
}