package com.gdou.gdousystem.bean;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Meng
 * @date 2019/12/22
 */
public class Course {
    private String courseId;
    private String version;
    private String courseName;
    private Integer theoreticalHours;
    private Integer experimentalHours;
    private Double credit;
    private String courseType;
    private String courseNature;
    private Teacher teacher;


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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
