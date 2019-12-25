package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.dto.CourseIndicatorDto;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface CourseIndicatorMapper {
    List<CourseIndicatorDto> selectAllCoursesIndicatorSelective(String toSqlParam);
}
