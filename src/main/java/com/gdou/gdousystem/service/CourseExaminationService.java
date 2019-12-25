package com.gdou.gdousystem.service;

import com.gdou.gdousystem.dto.CourseExaminationDto;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface CourseExaminationService {
    List<CourseExaminationDto> findAllCourseExaminationSelective(String version, String courseId);
}
