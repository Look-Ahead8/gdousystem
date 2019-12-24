package com.gdou.gdousystem.controller.course;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.CourseService;
import com.gdou.gdousystem.vo.CourseVO;
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
 * @date 2019/12/21
 */
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public Message findAllCourses(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Course> courses = courseService.findAllCourses();
        PageInfo<Course> pageInfo = new PageInfo<>(courses, 5);
        return Message.success().add("pageInfo", pageInfo);
    }

    @PostMapping("/course")
    public Message saveCourse(@Valid CourseVO course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        } else {
            boolean flag = courseService.saveCourse(course);
            if (flag) return Message.success();
            else return Message.fail();
        }
    }

    @PutMapping("/course")
    public Message updateCourseByCourseIdAndVersion(@Valid CourseVO courseVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        } else {
            boolean flag = courseService.updateCourseByCourseIdAndVersion(courseVO);
            if (flag) return Message.success();
            else return Message.fail();
        }
    }

    @GetMapping("/courseid")
    public Message findAllCourseId(){
        List<String> list=courseService.findAllCourseId();
        return Message.success().add("courseId",list);
    }

    @GetMapping("/version")
    public Message findAllVersionByCourseId(@RequestParam("courseId") String courseId){
        List<String> list=courseService.findAllVersionByCourseId(courseId);
        return Message.success().add("version",list);
    }

    @GetMapping("/course")
    public Message findCourseByCourseIdAndVersion(@RequestParam("courseId") String courseId,@RequestParam("version") String version){
        Course course=courseService.findCourseByCourseIdAndVersion(courseId,version);
        return Message.success().add("course",course);
    }

}
