package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.dto.GraduationRequirementReachDto;
import com.gdou.gdousystem.dto.IndividualAchievementDto;
import com.gdou.gdousystem.dto.Sql1Dto;
import com.gdou.gdousystem.dto.Sql2Dto;
import com.gdou.gdousystem.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface CourseMapper {
    List<Course> selectAllCourses();

    int insertCourse(CourseVO course);

    boolean updateCourseByCourseIdAndVersion(CourseVO courseVO);

    List<String> selectAllCourseId();

    List<String> selectAllVersionByCourseId(String courseId);

    Course selectCourseByCourseIdAndVersion(@Param("courseId") String courseId,@Param("version") String version);

    List<Sql1Dto> sql1(@Param("courseName") String courseName,@Param("version") String version);

    List<Sql2Dto> sql2(@Param("targetName") String targetName,@Param("courseName") String courseName,@Param("version") String version);

    List<IndividualAchievementDto> selectIndividualAchiebement(@Param("courseName") String courseName,@Param("version") String version,@Param("level") String level);

    List<GraduationRequirementReachDto> selectGraduationRequirementReach(@Param("indicatorName") String indicatorName,@Param("level") String level);
}
