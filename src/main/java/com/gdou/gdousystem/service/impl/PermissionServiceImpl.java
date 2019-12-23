package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Permission;
import com.gdou.gdousystem.dao.PermissionMapper;
import com.gdou.gdousystem.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据登录的教师id查找对应的权限
     * @param teacherId 教师id
     * @return 所拥有的权限
     */
    @Override
    public List<Permission> findPermissionByTeacherId(String teacherId){
        return permissionMapper.selectPermissionByTeacherId(teacherId);
    }
}
