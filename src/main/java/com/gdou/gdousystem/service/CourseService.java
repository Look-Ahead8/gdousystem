package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.vo.CourseVO;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public interface CourseService {
    List<Course> findAllCourses();

    boolean saveCourse(CourseVO course);

    boolean updateCourseByCourseIdAndVersion(CourseVO courseVO);
}
