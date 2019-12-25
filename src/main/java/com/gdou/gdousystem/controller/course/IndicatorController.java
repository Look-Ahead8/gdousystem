package com.gdou.gdousystem.controller.course;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.bean.Indicator;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.IndicatorService;
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
@RequestMapping("/course")
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class IndicatorController {
    @Autowired
    private IndicatorService indicatorService;

    @GetMapping("indicators")
    public Message findAllIndicators(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<Indicator> indicators = indicatorService.findAllIndicators();
        PageInfo<Indicator> pageInfo = new PageInfo<>(indicators, 5);
        return Message.success().add("pageInfo", pageInfo);

    }

    @PostMapping("indicator")
    public Message saveIndicator(@Valid Indicator indicator, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        }else{
            boolean flag=indicatorService.saveIndicator(indicator);
            if(flag) return Message.success();
            else return Message.fail();
        }
    }
}
