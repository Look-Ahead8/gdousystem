package com.gdou.gdousystem.controller.course;

import com.gdou.gdousystem.dto.CourseIndicatorDto;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.CourseIndicatorService;
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
@RequestMapping("/course")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class CourseIndicatorController {
    @Autowired
    private CourseIndicatorService courseIndicatorService;

    @RequestMapping("/courseindicators")
    public Message findAllCourseIndicatorsSelective(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "indicatorName",defaultValue = "")String indicatorName){
        PageHelper.startPage(pn, 10);
        List<CourseIndicatorDto> list = courseIndicatorService.findAllCoursesIndicatorSelective(indicatorName);
        PageInfo<CourseIndicatorDto> pageInfo = new PageInfo<>(list, 5);
        return Message.success().add("pageInfo",pageInfo);
    }
}

