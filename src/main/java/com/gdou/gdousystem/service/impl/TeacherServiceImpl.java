package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.dao.TeacherMapper;
import com.gdou.gdousystem.service.TeacherService;
import com.gdou.gdousystem.util.MD5Util;
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
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    /**根据教师号查找教师
     * @param teacherId 教师号
     * @return 对应的教师
     */
    @Override
    public Teacher findTeacherByTeacherId(String teacherId) {
        return teacherMapper.selectTeacherByTeacherId(teacherId);
    }

    /**
     * 查找全部的教师
     * @return 全部教师
     */
    @Override
    public List<Teacher> findAllTeachersSelective(String username,Integer roleId) {
        username=username.isEmpty()?"%":"%"+username+"%";
        roleId=roleId==0?null:roleId;
        return teacherMapper.selectAllTeachersSelective(username,roleId);
    }

    /**
     * 用户修改密码
     * @param password  新密码
     * @param ensurePassword  确认密码
     * @param teacherId  修改的教师账号
     * @return 0为修改成功,1为密码长度不符合要求，2为两次密码确认不一致
     */
    @Override
    public int updatePasswordByTeacherId(String password, String ensurePassword, String teacherId) {
       if(password.length()<6||password.length()>16||ensurePassword.length()<6||ensurePassword.length()>16){
           return 1;
       }
       if(!password.equals(ensurePassword)){
           return 2;
       }
       teacherMapper.updatePasswordByTeacherId(password,teacherId);
       return 0;
    }

    @Override
    public boolean deleteTeacherByTeacherId(String teacherId) {
        return teacherMapper.deleteTeacherByTeacherId(teacherId)==1;
    }

    @Override
    public boolean updateRoleByTeacherId(String teacherId, Integer[] roles) {
        teacherMapper.deleteRoleByTeacherId(teacherId);
        for (int i = 0; i <roles.length; i++) {
            Integer roleId=roles[i];
            teacherMapper.insertTeacherRole(teacherId,roleId);
        }
        return true;
    }

    @Override
    public boolean updateStatusByTeacherId(String teacherId) {
        Teacher teacher=teacherMapper.selectTeacherByTeacherId(teacherId);
        teacher.setStatus(!teacher.isStatus());
        return teacherMapper.updateStatusByTeacherId(teacher)==1;
    }

    @Override
    public boolean updateTeacherByTeacherId(String teacherId) {
        return teacherMapper.updateTeacherByTeacherId(teacherId)==1;
    }

    @Override
    public List<Teacher> findTeacherByMajor(String major) {
        return teacherMapper.selectTeacherByMajor(major);
    }

}
