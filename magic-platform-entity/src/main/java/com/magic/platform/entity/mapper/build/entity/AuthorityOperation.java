package com.magic.platform.entity.mapper.build.entity;

import javax.persistence.*;

@Table(name = "authority_operation")
public class AuthorityOperation {
    /**
     * 权限id
     */
    @Column(name = "authority_id")
    private String authorityId;

    /**
     * 操作id
     */
    @Column(name = "operation_id")
    private String operationId;

    /**
     * 获取权限id
     *
     * @return authority_id - 权限id
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 设置权限id
     *
     * @param authorityId 权限id
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }

    /**
     * 获取操作id
     *
     * @return operation_id - 操作id
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * 设置操作id
     *
     * @param operationId 操作id
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }
}