package com.gdou.gdousystem.service;

import com.gdou.gdousystem.dto.ExaminationDetailDto;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/25
 */
public interface ExaminationDetailService {
    List<ExaminationDetailDto> findAllCourseExaminationSelective(String version, String courseId, String type);
}
