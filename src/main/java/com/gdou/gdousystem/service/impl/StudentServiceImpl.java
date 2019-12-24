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
    public List<Student> findAllStudentsSelective(String department, String major, String year) {
        return studentMapper.selectAllStudentsSelective(toSelectiveSql(department),toSelectiveSql(major),toSelectiveSql(year));
    }

    @Override
    public Student findStudentByStudentId(String studentId) {
        return studentMapper.selectStudentByStudentId(studentId);
    }

    @Override
    public boolean updateStudentByStudentId(Student student) {
        return studentMapper.updateStudentByStudentId(student) == 1;
    }

    @Override
    public List<String> findAllDepartments() {
        return studentMapper.selectAllDepartments();
    }

    @Override
    public List<String> findMajorByDepartment(String department) {
        return studentMapper.selectMajorByDepartment(department);
    }

    @Override
    public List<String> findStudentClassByMajor(String major) {
        return studentMapper.selectStudentClassByMajor(major);
    }

    /**
     * 条件查询把参数转换为sql
     * @param str 参数
     * @return 模糊查询的关键词
     */
    private String toSelectiveSql(String str) {
        return str=str.isEmpty()?"%":"%"+str+"%";
    }
}
