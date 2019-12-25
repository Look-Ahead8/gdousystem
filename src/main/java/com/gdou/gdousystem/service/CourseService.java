package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.dto.CourseOverallAchievementDto;
import com.gdou.gdousystem.dto.GraduationRequirementReachDto;
import com.gdou.gdousystem.dto.IndividualAchievementDto;
import com.gdou.gdousystem.vo.CourseVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface CourseService {
    List<Course> findAllCourses();

    boolean saveCourse(CourseVO course);

    boolean updateCourseByCourseIdAndVersion(CourseVO courseVO);

    List<String> findAllCourseId();

    List<String> findAllVersionByCourseId(String courseId);

    Course findCourseByCourseIdAndVersion(String courseId, String version);

    List<CourseOverallAchievementDto> findOverallAchievement(String courseName, String version);

    List<IndividualAchievementDto> findIndividualAchiebement(String courseName, String version, String level);

    List<GraduationRequirementReachDto> findGraduationRequirementReach(String indicatorName, String level);

    HSSFWorkbook createOverallachievementExcel(String courseName, String version);

    HSSFWorkbook createGraduationRequirementReachExcel(String indicatorName, String level);

    HSSFWorkbook createIndividualAchiebementExcel(String version, String level,String courseName);
}
