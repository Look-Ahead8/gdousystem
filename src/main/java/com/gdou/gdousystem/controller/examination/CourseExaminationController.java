package com.gdou.gdousystem.controller.examination;

import com.gdou.gdousystem.dto.CourseExaminationDto;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.CourseExaminationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/examination")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class CourseExaminationController {
    @Autowired
    private CourseExaminationService courseExaminationService;

    @GetMapping("courseexaminations")
    public Message findAllCourseExaminationsSelective(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "version",defaultValue = "")String version,@RequestParam(value = "courseId",defaultValue = "")String courseId ){
        PageHelper.startPage(pn, 10);
        List<CourseExaminationDto> list = courseExaminationService.findAllCourseExaminationSelective(version,courseId);
        PageInfo<CourseExaminationDto> pageInfo = new PageInfo<>(list, 5);
        return Message.success().add("pageInfo", pageInfo);
    }

}
