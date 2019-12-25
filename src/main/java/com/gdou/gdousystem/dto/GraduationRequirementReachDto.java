package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class GraduationRequirementReachDto {
    private String indicatorName;
    private String targetName;
    private String courseId;
    private String version;
    private String courseName;
    private Double supportRate;
    private Double result;
    private Double weight;
    private Double graduationAchieve;

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

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

    public Double getSupportRate() {
        return supportRate;
    }

    public void setSupportRate(Double supportRate) {
        this.supportRate = supportRate;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getGraduationAchieve() {
        return graduationAchieve;
    }

    public void setGraduationAchieve(Double graduationAchieve) {
        this.graduationAchieve = graduationAchieve;
    }
}
