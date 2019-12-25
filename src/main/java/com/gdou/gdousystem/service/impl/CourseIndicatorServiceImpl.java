package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.dao.CourseIndicatorMapper;
import com.gdou.gdousystem.dto.CourseIndicatorDto;
import com.gdou.gdousystem.service.CourseIndicatorService;
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
public class CourseIndicatorServiceImpl implements CourseIndicatorService {
    @Autowired
    private CourseIndicatorMapper courseIndicatorMapper;

    @Override
    public List<CourseIndicatorDto> findAllCoursesIndicatorSelective(String indicatorName) {
        return courseIndicatorMapper.selectAllCoursesIndicatorSelective(toSqlParam(indicatorName));
    }

    private String toSqlParam(String str){
        return str=str.isEmpty()?"%":"%"+str+"%";
    }
}
