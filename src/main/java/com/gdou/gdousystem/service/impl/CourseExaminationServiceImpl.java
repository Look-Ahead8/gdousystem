package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.dao.CourseExaminationMapper;
import com.gdou.gdousystem.dto.CourseExaminationDto;
import com.gdou.gdousystem.service.CourseExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
@Service
@Transactional
public class CourseExaminationServiceImpl implements CourseExaminationService {
    @Autowired
    private CourseExaminationMapper courseExaminationMapper;

    @Override
    public List<CourseExaminationDto> findAllCourseExaminationSelective(String version, String courseId) {
        return courseExaminationMapper.selectAllCourseExaminationSelective(toSqlParam(version),toSqlParam(courseId));
    }

    private String toSqlParam(String str){
        return str.isEmpty()?"%":"%"+str+"%";
    }
}
