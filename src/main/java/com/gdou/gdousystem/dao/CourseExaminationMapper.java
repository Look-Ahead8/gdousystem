package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.dto.CourseExaminationDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface CourseExaminationMapper {
    List<CourseExaminationDto> selectAllCourseExaminationSelective(@Param("version") String version,@Param("courseId") String courseId);
}
