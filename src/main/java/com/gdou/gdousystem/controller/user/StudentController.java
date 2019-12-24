package com.gdou.gdousystem.controller.user;

import com.gdou.gdousystem.bean.Student;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/22
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
@ResponseBody
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 超级管理员查找全部学生，带分页数据
     * @param pn 当前第几页
     * @return 第pn页的学生数据
     */
    @GetMapping("/students")
    public Message findAllStudents(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "department",defaultValue = "")String department,@RequestParam(value = "majpr",defaultValue = "") String major,@RequestParam(value = "year",defaultValue = "")String year){
        PageHelper.startPage(pn,10);
        List<Student> students=studentService.findAllStudentsSelective(department,major,year);
        PageInfo<Student> pageInfo=new PageInfo<>(students,5);
        return Message.success().add("pageInfo",pageInfo);
    }

    @GetMapping("/student")
    public Message findStudentByStudentId(@RequestParam("studentId")String studentId){
        Student student=studentService.findStudentByStudentId(studentId);
        return Message.success().add("student",student);
    }

    @PutMapping("/student")
    public Message updateStudentByStudentId(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        }
        boolean flag=studentService.updateStudentByStudentId(student);
        if(flag)return Message.success();
        else return Message.fail();
    }
}
