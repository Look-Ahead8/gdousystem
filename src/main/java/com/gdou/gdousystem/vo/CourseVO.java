package com.gdou.gdousystem.vo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Meng
 * @date 2019/12/22
 */
public class CourseVO {
    @NotBlank(message = "课程号不可以为空")
    private String courseId;
    @NotBlank(message = "版本号不可以为空")
    private String version;
    @NotBlank(message = "课程名不可以为空")
    private String courseName;
    @NotNull(message = "理论学时不可以为空")
    private Integer theoreticalHours;
    @NotNull(message = "实验学时不可以为空")
    private Integer experimentalHours;
    @NotNull(message = "学分不可以为空")
    private Double credit;
    @NotBlank(message = "课程类别不可以为空")
    private String courseType;
    @NotBlank(message = "课程性质不可以为空")
    private String courseNature;
    @NotBlank(message = "编撰者id不可以为空")
    private String authorId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTheoreticalHours() {
        return theoreticalHours;
    }

    public void setTheoreticalHours(Integer theoreticalHours) {
        this.theoreticalHours = theoreticalHours;
    }

    public Integer getExperimentalHours() {
        return experimentalHours;
    }

    public void setExperimentalHours(Integer experimentalHours) {
        this.experimentalHours = experimentalHours;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseNature() {
        return courseNature;
    }

    public void setCourseNature(String courseNature) {
        this.courseNature = courseNature;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
