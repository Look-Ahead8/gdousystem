package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class IndividualAchievementDto {
    private Integer targetId;
    private String targetName;
    private String content;
    private Double targetSum;
    private Double targetThreshold;
    private Integer passStudentNumbers;
    private Integer totalStudentNumbers;
    private Double passRate;
    private boolean isReach;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getTargetSum() {
        return targetSum;
    }

    public void setTargetSum(Double targetSum) {
        this.targetSum = targetSum;
    }

    public Double getTargetThreshold() {
        return targetThreshold;
    }

    public void setTargetThreshold(Double targetThreshold) {
        this.targetThreshold = targetThreshold;
    }

    public Integer getPassStudentNumbers() {
        return passStudentNumbers;
    }

    public void setPassStudentNumbers(Integer passStudentNumbers) {
        this.passStudentNumbers = passStudentNumbers;
    }

    public Integer getTotalStudentNumbers() {
        return totalStudentNumbers;
    }

    public void setTotalStudentNumbers(Integer totalStudentNumbers) {
        this.totalStudentNumbers = totalStudentNumbers;
    }

    public Double getPassRate() {
        return passRate;
    }

    public void setPassRate(Double passRate) {
        this.passRate = passRate;
    }

    public boolean isReach() {
        return isReach;
    }

    public void setReach(boolean reach) {
        isReach = reach;
    }
}
