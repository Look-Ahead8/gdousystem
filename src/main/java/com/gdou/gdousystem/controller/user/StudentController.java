package com.gdou.gdousystem.controller.user;

import com.gdou.gdousystem.bean.Student;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Message findAllStudents(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,10);
        List<Student> students=studentService.findAllStudents();
        PageInfo<Student> pageInfo=new PageInfo<>(students,5);
        return Message.success().add("pageInfo",pageInfo);
    }
}
