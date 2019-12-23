package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Student;
import com.gdou.gdousystem.dao.StudentMapper;
import com.gdou.gdousystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findAllStudents() {
        return studentMapper.selectAllStudents();
    }
}
