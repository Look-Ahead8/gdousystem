package com.gdou.gdousystem.controller.course;

import com.gdou.gdousystem.bean.GraduationRequirement;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.GraduationRequirementService;
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
public class GraduationRequirementController {
    @Autowired
    private GraduationRequirementService graduationRequirementService;

    @GetMapping("graduationrequirements")
    public Message findAllGraduationRequirements(){
        List<GraduationRequirement> list= graduationRequirementService.findAllGraduationRequirements();
        return Message.success().add("graduationRequirement",list);
    }

    @PostMapping("graduationrequirement")
    public Message saveGraduationRequirement(@Valid GraduationRequirement graduationRequirement, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Message.fail().add("errors", map);
        }else{
            boolean flag=graduationRequirementService.saveGraduationRequirement(graduationRequirement);
            if(flag) return Message.success();
            else return Message.fail();
        }
    }

    @DeleteMapping("graduationrequirement")
    public Message deleteGraduationRequirement(@RequestParam("graduationRequirementId") Integer graduationRequirementId){
        boolean flag=graduationRequirementService.deleteGraduationRequirement(graduationRequirementId);
        if(flag) return Message.success();
        else return Message.fail().add("error","请注意该要求的指标点是否删除完毕");
    }
}
