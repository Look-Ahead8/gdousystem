package com.gdou.gdousystem.service;


import com.gdou.gdousystem.bean.Student;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface StudentService {
    List<Student> findAllStudentsSelective(String department,String major,String year);

    Student findStudentByStudentId(String studentId);

    boolean updateStudentByStudentId(Student student);

    List<String> findAllDepartments();

    List<String> findMajorByDepartment(String department);

    List<String> findStudentClassByMajor(String major);
}
