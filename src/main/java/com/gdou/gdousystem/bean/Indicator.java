package com.gdou.gdousystem.bean;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public class Indicator {
    private String indicatorId;
    private String indicatorContent;
    private String indicatorName;
    private Integer graduationRequirementId;
    private List<TeacherTarget> teacherTarget;

    public String getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(String indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getIndicatorContent() {
        return indicatorContent;
    }

    public void setIndicatorContent(String indicatorContent) {
        this.indicatorContent = indicatorContent;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public Integer getGraduationRequirementId() {
        return graduationRequirementId;
    }

    public void setGraduationRequirementId(Integer graduationRequirementId) {
        this.graduationRequirementId = graduationRequirementId;
    }

    public List<TeacherTarget> getTeacherTarget() {
        return teacherTarget;
    }

    public void setTeacherTarget(List<TeacherTarget> teacherTarget) {
        this.teacherTarget = teacherTarget;
    }
}
