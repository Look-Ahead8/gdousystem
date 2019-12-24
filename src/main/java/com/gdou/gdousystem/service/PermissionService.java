package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Permission;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public interface PermissionService {
    List<Permission> findPermissionByTeacherId(String teacherId);

    List<Permission> findPermissionByRoleId(Integer roleId);
}
