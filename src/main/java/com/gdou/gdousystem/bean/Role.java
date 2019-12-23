package com.gdou.gdousystem.bean;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public class Role {
    private Integer roleId;
    private String roleName;
    private List<Teacher> teacher;
    private List<Permission> permission;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }
}
