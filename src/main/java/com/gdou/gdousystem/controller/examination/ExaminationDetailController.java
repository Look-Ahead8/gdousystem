package com.gdou.gdousystem.controller.examination;

import com.gdou.gdousystem.dto.ExaminationDetailDto;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.ExaminationDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/25
 */
@RestController
@RequestMapping("/examination")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class ExaminationDetailController {
    @Autowired
    private ExaminationDetailService examinationDetailService;

    @GetMapping("examinationdetails")
    public Message findAllExaminationDetailSelective(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value = "courseId",defaultValue = "")String courseId,@RequestParam(value = "version",defaultValue = "")String version,@RequestParam(value = "type",defaultValue = "")String type){
        PageHelper.startPage(pn, 10);
        List<ExaminationDetailDto> list = examinationDetailService.findAllCourseExaminationSelective(version,courseId,type);
        PageInfo<ExaminationDetailDto> pageInfo = new PageInfo<>(list, 5);
        return Message.success().add("pageInfo", pageInfo);
    }
}
