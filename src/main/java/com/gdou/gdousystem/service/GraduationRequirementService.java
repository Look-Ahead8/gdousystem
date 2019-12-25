package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.GraduationRequirement;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface GraduationRequirementService {
    List<GraduationRequirement> findAllGraduationRequirements();

    boolean saveGraduationRequirement(GraduationRequirement graduationRequirement);

    boolean deleteGraduationRequirement(Integer graduationRequirementId);
}
