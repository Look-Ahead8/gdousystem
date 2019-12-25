package com.gdou.gdousystem.controller.schedule;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.ScheduleService;
import com.gdou.gdousystem.service.StudentService;
import com.gdou.gdousystem.service.TeacherService;
import com.gdou.gdousystem.vo.DeleteScheduleVO;
import com.gdou.gdousystem.vo.ScheduleVO;
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
    @Autowired
    private ScheduleService scheduleService;

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

    @PostMapping("schedule")
    public Message saveSchedule(@Valid  ScheduleVO schedule, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        }else{
            boolean flag=scheduleService.saveSchedule(schedule);
            if(flag) return Message.success();
            else return Message.fail();
        }
    }

    @GetMapping("schedules")
    public Message findAllSchedulesSelective(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "department",defaultValue = "")String department,@RequestParam(value = "major",defaultValue = "")String major,@RequestParam(value = "studentClass",defaultValue = "")String studentClass){
        PageHelper.startPage(pn, 10);
        List<Course> schedules = scheduleService.findAllSchedulesSelective(department,major,studentClass);
        PageInfo<Course> pageInfo = new PageInfo<>(schedules, 5);
        return Message.success().add("pageInfo", pageInfo);
    }

    @DeleteMapping("schedule")
    public Message deleteScheduleByDeleteScheduleVO(@Valid DeleteScheduleVO schedule,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        }else{
            boolean flag=scheduleService.deleteScheduleByDeleteScheduleVO(schedule);
            if(flag) return Message.success();
            else return Message.fail();
        }
    }
}
