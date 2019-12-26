package com.gdou.gdousystem.service;

import com.gdou.gdousystem.dto.IndicatorTargetDto;
import com.gdou.gdousystem.dto.TargetCourseDto;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/26
 */
public interface TeachingTargetService {
    List<IndicatorTargetDto> selectAllTargetIndicatorSelective(String indicatorName);

    List<TargetCourseDto> findAllTargetCoursesSelective(String courseName, String version);
}
