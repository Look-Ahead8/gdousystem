package com.gdou.gdousystem.controller.schedule;

import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.StudentService;
import com.gdou.gdousystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*",maxAge = 3600)
@ResponseBody
public class ScheduleController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/department")
    public Message findAllDepartments(){
        List<String> list=studentService.findAllDepartments();
        return Message.success().add("department",list);
    }

    @GetMapping("/major")
    public Message findMajorByDepartment(@RequestParam("department")String department){
        List<String> list=studentService.findMajorByDepartment(department);
        return Message.success().add("major",list);
    }

    @GetMapping("studentclass")
    public Message findStudentClassByMajor(@RequestParam("major")String major){
        List<String> list=studentService.findStudentClassByMajor(major);
        return Message.success().add("studentClass",list);
    }

    @GetMapping("scheduleteacher")
    public Message findTeacherByMajor(@RequestParam("major") String major){
        List<Teacher> list=teacherService.findTeacherByMajor(major);
        return Message.success().add("teacher",list);
    }
}
