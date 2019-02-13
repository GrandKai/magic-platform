package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

public class Permission {
    @Id
    private String id;

    private String name;

    /**
     * 访问许可地址（即：api url 地址）
     */
    private String url;

    /**
     * 所属操作
     */
    @Column(name = "operation_id")
    private String operationId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "sort_number")
    private Short sortNumber;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取访问许可地址（即：api url 地址）
     *
     * @return url - 访问许可地址（即：api url 地址）
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问许可地址（即：api url 地址）
     *
     * @param url 访问许可地址（即：api url 地址）
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取所属操作
     *
     * @return operation_id - 所属操作
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * 设置所属操作
     *
     * @param operationId 所属操作
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
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
}