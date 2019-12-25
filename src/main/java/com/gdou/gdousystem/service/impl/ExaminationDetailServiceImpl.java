package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.dao.ExaminationDetailMapper;
import com.gdou.gdousystem.dto.ExaminationDetailDto;
import com.gdou.gdousystem.service.ExaminationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/25
 */
@Service
@Transactional
public class ExaminationDetailServiceImpl implements ExaminationDetailService {
    @Autowired
    private ExaminationDetailMapper examinationDetailMapper;

    @Override
    public List<ExaminationDetailDto> findAllCourseExaminationSelective(String version, String courseId, String type) {
        return examinationDetailMapper.selectAllCourseExaminationSelective(toSqlParam(version),toSqlParam(courseId),toSqlParam(type));
    }

    private String toSqlParam(String  str){
        return str=str.isEmpty()?"%":"%"+str+"%";
    }
}
