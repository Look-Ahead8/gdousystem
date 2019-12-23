package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.dao.CourseMapper;
import com.gdou.gdousystem.service.CourseService;
import com.gdou.gdousystem.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAllCourses() {
        return courseMapper.selectAllCourses();
    }

    @Override
    public boolean saveCourse(CourseVO course) {
        return courseMapper.insertCourse(course)==1;
    }

    @Override
    public boolean updateCourseByCourseIdAndVersion(CourseVO courseVO) {
        return courseMapper.updateCourseByCourseIdAndVersion(courseVO);
    }
}
