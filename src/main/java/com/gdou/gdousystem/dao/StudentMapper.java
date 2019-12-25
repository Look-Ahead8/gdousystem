package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Schedule;
import com.gdou.gdousystem.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface StudentMapper {
    List<Student> selectAllStudentsSelective(@Param("department") String department, @Param("major") String major, @Param("year") String year);

    Student selectStudentByStudentId(String studentId);

    int updateStudentByStudentId(Student student);

    List<String> selectAllDepartments();

    List<String> selectMajorByDepartment(String department);

    List<String> selectStudentClassByMajor(String major);

    List<String> selectAllStudentIdByDepartmentAndMajorAndStudentClass(@Param("department") String department,@Param("major") String major, @Param("studentClass") String studentClass);
}
