package com.gdou.gdousystem.service;

import com.gdou.gdousystem.dto.CourseIndicatorDto;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface CourseIndicatorService {
    List<CourseIndicatorDto> findAllCoursesIndicatorSelective(String indicatorName);
}
