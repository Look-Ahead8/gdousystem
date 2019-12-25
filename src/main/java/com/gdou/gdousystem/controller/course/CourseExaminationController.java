package com.gdou.gdousystem.controller.course;

import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.CourseExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Meng
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class CourseExaminationController {
    @Autowired
    private CourseExaminationService courseExaminationService;

//    @GetMapping("courseexaminations")
//    public Message findAllCourseExaminationsSelective(@RequestParam)

}
