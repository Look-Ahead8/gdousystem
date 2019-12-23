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

    List<Teacher> selectAllTeachers();

    void updatePasswordByTeacherId(@Param("password") String password,@Param("teacherId") String teacherId);

    int deleteTeacherByTeacherId(String teacherId);
}
