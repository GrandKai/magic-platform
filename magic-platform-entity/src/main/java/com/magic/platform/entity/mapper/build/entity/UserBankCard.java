package com.magic.platform.entity.mapper.build.entity;

import javax.persistence.*;

@Table(name = "user_bank_card")
public class UserBankCard {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    /**
     * 开户名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 开户支行
     */
    @Column(name = "bank_branch")
    private String bankBranch;

    /**
     * 银行卡号
     */
    @Column(name = "bank_no")
    private String bankNo;

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取开户名
     *
     * @return account_name - 开户名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置开户名
     *
     * @param accountName 开户名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取银行名称
     *
     * @return bank_name - 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取开户支行
     *
     * @return bank_branch - 开户支行
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * 设置开户支行
     *
     * @param bankBranch 开户支行
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

    /**
     * 获取银行卡号
     *
     * @return bank_no - 银行卡号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankNo 银行卡号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }
}