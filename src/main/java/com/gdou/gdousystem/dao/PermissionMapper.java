package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Permission;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public interface PermissionMapper {
    List<Permission> selectPermissionByTeacherId(String teacherId);

    List<Permission> selectPermissionByRoleId(Integer roleId);
}
