package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Teacher;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public interface TeacherService {
    Teacher findTeacherByTeacherId(String teacherId);

    List<Teacher> findAllTeachers();

    int updatePasswordByTeacherId(String password, String ensurePassword, String teacherId);

    boolean deleteTeacherByTeacherId(String teacherId);
}
