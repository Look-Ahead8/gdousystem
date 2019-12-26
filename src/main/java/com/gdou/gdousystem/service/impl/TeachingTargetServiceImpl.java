package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.dao.TeachingTargetMapper;
import com.gdou.gdousystem.dto.IndicatorTargetDto;
import com.gdou.gdousystem.dto.TargetCourseDto;
import com.gdou.gdousystem.service.TeachingTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/26
 */
@Service
@Transactional
public class TeachingTargetServiceImpl implements TeachingTargetService {
    @Autowired
    private TeachingTargetMapper teachingTargetMapper;

    @Override
    public List<IndicatorTargetDto> selectAllTargetIndicatorSelective(String indicatorName) {
        return teachingTargetMapper.selectAllTargetIndicatorSelective(toSqlParam(indicatorName));
    }

    @Override
    public List<TargetCourseDto> findAllTargetCoursesSelective(String courseName, String version) {
        return teachingTargetMapper.selectAllTargetCoursesSelective(toSqlParam(courseName),toSqlParam(version));
    }

    private String toSqlParam(String str){
        return str.isEmpty()?"%":"%"+str+"%";
    }
}
