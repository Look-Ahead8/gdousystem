package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Role;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public interface RoleService {
    List<Role> findRoleByTeacherId(String teacherId);

    List<Role> findAllRoles();
}
