package com.gdou.gdousystem.bean;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public class Permission {
    private Integer permissionId;
    private String permissionName;
    private List<Role> role;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
