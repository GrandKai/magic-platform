package com.magic.platform.entity.mapper.build.entity;

import javax.persistence.*;

@Table(name = "authority_menu")
public class AuthorityMenu {
    /**
     * 权限id
     */
    @Column(name = "authority_id")
    private String authorityId;

    /**
     * 菜单id
     */
    @Column(name = "menu_id")
    private String menuId;

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
     * 获取菜单id
     *
     * @return menu_id - 菜单id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}