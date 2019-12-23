package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Role;
import com.gdou.gdousystem.dao.RoleMapper;
import com.gdou.gdousystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleByTeacherId(String teacherId) {
        return roleMapper.selectRoleByTeacherId(teacherId);
    }
}
