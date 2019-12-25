package com.gdou.gdousystem.controller.score;

import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.ScoreService;
import com.gdou.gdousystem.util.ExcelExportUtil;
import com.gdou.gdousystem.vo.GetExcelVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/25
 */
@RestController
@RequestMapping("/score")
@CrossOrigin(origins = "*",maxAge = 3600)
@ResponseBody
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "/createExecl")
    public String createExcel(HttpServletResponse response, @Valid GetExcelVO getExcelVO, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return "fail";
        }
        HSSFWorkbook workbook=scoreService.createExcel(getExcelVO);
        if(workbook==null)return "fail";
        else{
            String fileName="成绩等级表.xls";
            ExcelExportUtil.buildExcelFile(fileName,workbook);
            ExcelExportUtil.buildExcelDocument(fileName,workbook,response);
        }
        return "down excel";
    }
}
