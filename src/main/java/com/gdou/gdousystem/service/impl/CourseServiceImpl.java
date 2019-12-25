package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.dao.CourseMapper;
import com.gdou.gdousystem.dto.*;
import com.gdou.gdousystem.service.CourseService;
import com.gdou.gdousystem.util.ExcelExportUtil;
import com.gdou.gdousystem.vo.CourseVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/22
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAllCourses() {
        return courseMapper.selectAllCourses();
    }

    @Override
    public boolean saveCourse(CourseVO course) {
        return courseMapper.insertCourse(course)==1;
    }

    @Override
    public boolean updateCourseByCourseIdAndVersion(CourseVO courseVO) {
        return courseMapper.updateCourseByCourseIdAndVersion(courseVO);
    }

    @Override
    public List<String> findAllCourseId() {
        return courseMapper.selectAllCourseId();
    }

    @Override
    public List<String> findAllVersionByCourseId(String courseId) {
        return courseMapper.selectAllVersionByCourseId(courseId);
    }

    @Override
    public Course findCourseByCourseIdAndVersion(String courseId, String version) {
        return courseMapper.selectCourseByCourseIdAndVersion(courseId,version);
    }

    @Override
    public List<CourseOverallAchievementDto> findOverallAchievement(String courseName, String version) {
        List<Sql1Dto> sql1=courseMapper.sql1(courseName,version);
        List<CourseOverallAchievementDto> list=new ArrayList<>();
        for (Sql1Dto sql1Dto:sql1){
            CourseOverallAchievementDto courseOverallAchievementDto=new CourseOverallAchievementDto();
            courseOverallAchievementDto.setActualSum(sql1Dto.getActualSum());
            courseOverallAchievementDto.setResult(sql1Dto.getResult());
            courseOverallAchievementDto.setTargetSum(sql1Dto.getTargetSum());
            courseOverallAchievementDto.setContent(sql1Dto.getContent());
            courseOverallAchievementDto.setTargetName(sql1Dto.getTargetName());
            List<Sql2Dto> sql2=courseMapper.sql2(sql1Dto.getTargetName(),courseName,version);
            List<Map<String,Double>> type=new ArrayList<>();
            Map<String,Double> map=new HashMap<>();
            for(Sql2Dto sql2Dto:sql2){
                map.put(sql2Dto.getType(),sql2Dto.getResult());
            }
            type.add(map);
            courseOverallAchievementDto.setType(type);
            list.add(courseOverallAchievementDto);
        }
        return list;
    }

    @Override
    public List<IndividualAchievementDto> findIndividualAchiebement(String courseName, String version, String level) {
        List<IndividualAchievementDto>  list=courseMapper.selectIndividualAchiebement(courseName,version,level);
        for (IndividualAchievementDto individualAchievementDto:list) {
            individualAchievementDto.setReach(individualAchievementDto.getPassRate()>0.6);
        }
        return list;
    }

    @Override
    public List<GraduationRequirementReachDto> findGraduationRequirementReach(String indicatorName, String level) {
        return courseMapper.selectGraduationRequirementReach(indicatorName,level);
    }

    @Override
    public HSSFWorkbook createOverallachievementExcel(String courseName, String version) {
        Map<String, Object> execlMap = new HashMap<>();
        List<String> headerList=new ArrayList<>();
        List<List<String>> data=new ArrayList<>();
        headerList.add("课程目标");
        headerList.add("考试");
        headerList.add("实验");
        headerList.add("作业");
        headerList.add("实际总分");
        headerList.add("目标总分");
        headerList.add("达成度");
        return null;
    }

    @Override
    public HSSFWorkbook createGraduationRequirementReachExcel(String indicatorName, String level) {
        Map<String, Object> execlMap = new HashMap<>();
        List<String> headerList=new ArrayList<>();
        List<List<String>> data=new ArrayList<>();
        headerList.add("指标名字");
        headerList.add("目标名字");
        headerList.add("课程号");
        headerList.add("版本号");
        headerList.add("课程名");
        headerList.add("支撑度");
        headerList.add("课程总体达成度");
        headerList.add("目标占指标权重");
        headerList.add("课程毕业达成度");
        List<GraduationRequirementReachDto> graduationRequirementReach = findGraduationRequirementReach(indicatorName,level);
        Double sum=0.0;
        for(GraduationRequirementReachDto graduationRequirementReachDto:graduationRequirementReach){
            List<String> list=new ArrayList<>();
            list.add(graduationRequirementReachDto.getIndicatorName());
            list.add(graduationRequirementReachDto.getTargetName());
            list.add(graduationRequirementReachDto.getCourseId());
            list.add(graduationRequirementReachDto.getVersion());
            list.add(graduationRequirementReachDto.getCourseName());
            list.add(String.valueOf(graduationRequirementReachDto.getSupportRate()));
            list.add(String.valueOf(graduationRequirementReachDto.getResult()));
            list.add(String.valueOf(graduationRequirementReachDto.getWeight()));
            list.add(String.valueOf(graduationRequirementReachDto.getGraduationAchieve()));
            sum+=graduationRequirementReachDto.getGraduationAchieve();
            data.add(list);
        }
        for (int i = 0; i <12 ; i++) {
            List<String> list=new ArrayList<>();
            if(i<10){
                for (int j = 0; j <9 ; j++) {
                    list.add("");
                }
            }
            else if(i==10){
                list.add("指标名字");
                list.add("指标对应毕业要求达成度");
                for (int j = 0; j <7 ; j++) {
                    list.add("");
                }
            }
            else{
                list.add(indicatorName);
                list.add(String.valueOf(sum));
                for (int j = 0; j <7 ; j++) {
                    list.add("");
                }
            }
            data.add(list);
        }
        execlMap.put("data",data);
        execlMap.put("header",headerList);
        execlMap.put("isSerial",false);
        execlMap.put("sheetName","毕业要求达成度分析");
        return ExcelExportUtil.createExcel(execlMap);
    }

    @Override
    public HSSFWorkbook createIndividualAchiebementExcel(String version, String level,String courseName) {
        Map<String, Object> execlMap = new HashMap<>();
        List<String> headerList=new ArrayList<>();
        List<List<String>> data=new ArrayList<>();
        headerList.add("课程目标");
        headerList.add("目标总分");
        headerList.add("目标阙值");
        headerList.add("通过人数");
        headerList.add("总人数");
        headerList.add("通过率");
        List<IndividualAchievementDto> individualAchiebement = findIndividualAchiebement(courseName, version,level);
        for(IndividualAchievementDto individualAchievementDto:individualAchiebement){
            List<String> list=new ArrayList<>();
            list.add(individualAchievementDto.getTargetName());
            list.add(String.valueOf(individualAchievementDto.getTargetSum()));
            list.add(String.valueOf(individualAchievementDto.getTargetThreshold()));
            list.add(String.valueOf(individualAchievementDto.getPassStudentNumbers()));
            list.add(String.valueOf(individualAchievementDto.getTotalStudentNumbers()));
            list.add(String.valueOf(individualAchievementDto.getPassRate()));
            data.add(list);
        }
        execlMap.put("data",data);
        execlMap.put("header",headerList);
        execlMap.put("isSerial",false);
        execlMap.put("sheetName","个体达成度分析");
        return ExcelExportUtil.createExcel(execlMap);
    }
}
