package com.gdou.gdousystem.bean;

/**
 * @author Meng
 * @date 2019/12/22
 */
public class CourseExaminationWeight {
    private Integer courExamWeightId;
    private double examinationWeight;
    private ExaminationType examinationType;
    private String level;
    private CourseLeader courseLeader;
    private String courseName;
    private String targetName;

    public Integer getCourExamWeightId() {
        return courExamWeightId;
    }

    public void setCourExamWeightId(Integer courExamWeightId) {
        this.courExamWeightId = courExamWeightId;
    }

    public double getExaminationWeight() {
        return examinationWeight;
    }

    public void setExaminationWeight(double examinationWeight) {
        this.examinationWeight = examinationWeight;
    }

    public ExaminationType getExaminationType() {
        return examinationType;
    }

    public void setExaminationType(ExaminationType examinationType) {
        this.examinationType = examinationType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public CourseLeader getCourseLeader() {
        return courseLeader;
    }

    public void setCourseLeader(CourseLeader courseLeader) {
        this.courseLeader = courseLeader;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
