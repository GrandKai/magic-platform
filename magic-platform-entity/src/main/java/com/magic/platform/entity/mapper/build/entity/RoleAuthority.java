package com.magic.platform.entity.mapper.build.entity;

import javax.persistence.*;

@Table(name = "role_authority")
public class RoleAuthority {
    @Column(name = "role_id")
    private String roleId;

    @Column(name = "authority_id")
    private String authorityId;

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * @return authority_id
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * @param authorityId
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }
}