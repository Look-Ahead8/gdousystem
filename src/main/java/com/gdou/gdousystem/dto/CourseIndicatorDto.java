package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/24
 */
public class CourseIndicatorDto {
    private Integer weightId;
    private String courseId;
    private String courseName;
    private String version;
    private Double courseIndicatorWeight;

    public Integer getWeightId() {
        return weightId;
    }

    public void setWeightId(Integer weightId) {
        this.weightId = weightId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getCourseIndicatorWeight() {
        return courseIndicatorWeight;
    }

    public void setCourseIndicatorWeight(Double courseIndicatorWeight) {
        this.courseIndicatorWeight = courseIndicatorWeight;
    }
}
