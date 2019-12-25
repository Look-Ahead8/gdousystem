package com.gdou.gdousystem.bean;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public class Indicator {
    private String indicatorId;
    @NotBlank(message = "指标点内容不可以为空")
    private String indicatorContent;
    @NotBlank(message = "指标带你名称不可以为空")
    private String indicatorName;
    private GraduationRequirement graduationRequirement;
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

    public GraduationRequirement getGraduationRequirement() {
        return graduationRequirement;
    }

    public void setGraduationRequirement(GraduationRequirement graduationRequirement) {
        this.graduationRequirement = graduationRequirement;
    }

    public List<TeacherTarget> getTeacherTarget() {
        return teacherTarget;
    }

    public void setTeacherTarget(List<TeacherTarget> teacherTarget) {
        this.teacherTarget = teacherTarget;
    }
}
