package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Course;
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
}
