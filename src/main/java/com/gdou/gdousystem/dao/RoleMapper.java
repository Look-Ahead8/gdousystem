package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Role;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public interface RoleMapper {
    List<Role> selectRoleByTeacherId(String teacherId);

    List<Role> selectAllRoles();
}
