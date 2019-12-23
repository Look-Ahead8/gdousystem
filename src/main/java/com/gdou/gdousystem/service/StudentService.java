package com.gdou.gdousystem.service;


import com.gdou.gdousystem.bean.Student;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface StudentService {
    List<Student> findAllStudents();
}
