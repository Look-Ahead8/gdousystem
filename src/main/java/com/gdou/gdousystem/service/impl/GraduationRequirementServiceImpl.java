package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.GraduationRequirement;
import com.gdou.gdousystem.dao.GraduationRequirementMapper;
import com.gdou.gdousystem.service.GraduationRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
@Service
@Transactional
public class GraduationRequirementServiceImpl implements GraduationRequirementService {
    @Autowired
    private GraduationRequirementMapper graduationRequirementMapper;


    @Override
    public List<GraduationRequirement> findAllGraduationRequirements() {
        return  graduationRequirementMapper.selectAllGraduationRequirements();
    }

    @Override
    public boolean saveGraduationRequirement(GraduationRequirement graduationRequirement) {
        List<GraduationRequirement> list=findAllGraduationRequirements();
        if(list.size()==12)return false;
        return graduationRequirementMapper.insertGraduationRequirement(graduationRequirement)>0;
    }

    @Override
    public boolean deleteGraduationRequirement(Integer graduationRequirementId) {
        GraduationRequirement graduationRequirement=graduationRequirementMapper.selectGraduationRequirementById(graduationRequirementId);
        if(graduationRequirement.getIndicator().size()!=0)return false;
        return graduationRequirementMapper.deleteGraduationRequirement(graduationRequirementId)>0;
    }
}
