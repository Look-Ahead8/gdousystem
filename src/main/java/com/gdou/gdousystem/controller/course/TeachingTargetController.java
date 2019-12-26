package com.gdou.gdousystem.controller.course;

import com.gdou.gdousystem.dto.IndicatorTargetDto;
import com.gdou.gdousystem.dto.TargetCourseDto;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.TeachingTargetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/26
 */
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class TeachingTargetController {
    @Autowired
    private TeachingTargetService teachingTargetService;
    @GetMapping("/targetindicator")
    public Message findAllTargetIndicatorSelective(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "indicatorName",defaultValue = "")String indicatorName){
        PageHelper.startPage(pn,10);
        List<IndicatorTargetDto> list=teachingTargetService.selectAllTargetIndicatorSelective(indicatorName);
        PageInfo<IndicatorTargetDto> pageInfo=new PageInfo<>(list,5);
        return Message.success().add("pageInfo",pageInfo);
    }

    @GetMapping("targetcourse")
    public Message findAllTargetCoursesSelective(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "courseName",defaultValue = "")String courseName,@RequestParam(value = "version",defaultValue = "")String version){
        PageHelper.startPage(pn,10);
        List<TargetCourseDto> list=teachingTargetService.findAllTargetCoursesSelective(courseName,version);
        PageInfo<TargetCourseDto> pageInfo=new PageInfo<>(list,5);
        return Message.success().add("pageInfo",pageInfo);
    }
}
