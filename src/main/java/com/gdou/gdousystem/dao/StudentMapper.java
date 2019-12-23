package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Student;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface StudentMapper {
    List<Student> selectAllStudents();
}
