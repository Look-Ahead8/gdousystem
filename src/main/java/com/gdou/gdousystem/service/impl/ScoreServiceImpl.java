package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Schedule;
import com.gdou.gdousystem.bean.Student;
import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.dao.ExaminationDetailMapper;
import com.gdou.gdousystem.dao.ScheduleMapper;
import com.gdou.gdousystem.dao.ScoreMapper;
import com.gdou.gdousystem.dto.ExeclHeaderDto;
import com.gdou.gdousystem.service.ScoreService;
import com.gdou.gdousystem.util.ExcelExportUtil;
import com.gdou.gdousystem.vo.GetExcelVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/25
 */
@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private ExaminationDetailMapper examinationDetailMapper;

    @Override
    public HSSFWorkbook createExcel(GetExcelVO getExcelVO) {
        Teacher teacher=(Teacher) SecurityUtils.getSubject().getSession().getAttribute("teacher");
        getExcelVO.setTeacherId(teacher.getTeacherId());
        List<Student> students=scheduleMapper.selectScheduleByCourseAndTermAndTeacherId(getExcelVO);
        if(students.isEmpty())return null;
        else {
            List<ExeclHeaderDto> lists=examinationDetailMapper.selectAllDetailsByTeacherAndCourseAndTerm(getExcelVO);
            Map<String, Object> execlMap = new HashMap<>();
            List<String> headerList=new ArrayList<>();
            List<List<String>> data=new ArrayList<>();
            headerList.add("学号");
            headerList.add("姓名");
            for(ExeclHeaderDto execlHeaderDto:lists){
                if(execlHeaderDto.getIsWeight().equals("0")) {
                    headerList.add(execlHeaderDto.getDetailName() + "(" + execlHeaderDto.getTargetName() + ")\n" + "(" + execlHeaderDto.getDetailScore() + ")");
                }else{
                    headerList.add(execlHeaderDto.getDetailName() + "(" + execlHeaderDto.getTargetName() + ")\n" + "(" + execlHeaderDto.getDetailWeight() + "%)");
                }
            }
            for(Student student:students){
                List<String> list=new ArrayList<>();
                list.add(student.getStudentId());
                list.add(student.getStudentName());
                for(int i=0;i<headerList.size();i++){
                    list.add("");
                }
                data.add(list);
            }
            execlMap.put("data",data);
            execlMap.put("header",headerList);
            execlMap.put("isSerial",false);
            execlMap.put("sheetName","成绩登记表");
            return ExcelExportUtil.createExcel(execlMap);
        }
    }
}
