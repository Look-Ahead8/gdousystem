package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.vo.CourseVO;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface CourseMapper {
    List<Course> selectAllCourses();

    int insertCourse(CourseVO course);

    boolean updateCourseByCourseIdAndVersion(CourseVO courseVO);
}
