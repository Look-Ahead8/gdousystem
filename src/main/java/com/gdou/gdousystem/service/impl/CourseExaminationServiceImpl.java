package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.dao.CourseExaminationMapper;
import com.gdou.gdousystem.service.CourseExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Meng
 * @date 2019/12/24
 */
@Service
@Transactional
public class CourseExaminationServiceImpl implements CourseExaminationService {
    @Autowired
    private CourseExaminationMapper courseExaminationMapper;
}
