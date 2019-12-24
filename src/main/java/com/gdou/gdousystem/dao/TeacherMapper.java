package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public interface TeacherMapper {
    Teacher selectTeacherByTeacherId(String teacherId);

    List<Teacher> selectAllTeachersSelective(@Param("username") String username,@Param("roleId") Integer roleId);

    void updatePasswordByTeacherId(@Param("password") String password,@Param("teacherId") String teacherId);

    int deleteTeacherByTeacherId(String teacherId);

    void deleteRoleByTeacherId(String teacherId);

    void insertTeacherRole(@Param("teacherId") String teacherId, @Param("roleId") Integer roleId);

    int updateStatusByTeacherId(Teacher teacher);

    int updateTeacherByTeacherId(String teacherId);

    List<Teacher> selectTeacherByMajor(String major);
}
