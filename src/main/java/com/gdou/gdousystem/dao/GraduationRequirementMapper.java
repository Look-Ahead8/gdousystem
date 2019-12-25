package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.GraduationRequirement;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface GraduationRequirementMapper {
    List<GraduationRequirement> selectAllGraduationRequirements();

    int insertGraduationRequirement(GraduationRequirement graduationRequirement);

    GraduationRequirement selectGraduationRequirementById(Integer graduationRequirementId);

    int deleteGraduationRequirement(Integer graduationRequirementId);
}
