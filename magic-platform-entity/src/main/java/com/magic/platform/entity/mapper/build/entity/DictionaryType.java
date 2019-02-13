package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dictionary_type")
public class DictionaryType {
    /**
     * 编码类型id
     */
    @Id
    private String id;

    /**
     * 编码类型说明
     */
    private String name;

    /**
     * 数据类型编码
     */
    private String code;

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

    @Column(name = "is_show")
    private String isShow;

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
     * 获取编码类型id
     *
     * @return id - 编码类型id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编码类型id
     *
     * @param id 编码类型id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取编码类型说明
     *
     * @return name - 编码类型说明
     */
    public String getName() {
        return name;
    }

    /**
     * 设置编码类型说明
     *
     * @param name 编码类型说明
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取数据类型编码
     *
     * @return code - 数据类型编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置数据类型编码
     *
     * @param code 数据类型编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * @return is_show
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * @param isShow
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
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