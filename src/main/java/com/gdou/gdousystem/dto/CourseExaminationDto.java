package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/24
 */
public class CourseExaminationDto {
    private Integer courExamWeightId;
    private String courseName;
    private String examinationWeight;
    private String level;

    public Integer getCourExamWeightId() {
        return courExamWeightId;
    }

    public void setCourExamWeightId(Integer courExamWeightId) {
        this.courExamWeightId = courExamWeightId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getExaminationWeight() {
        return examinationWeight;
    }

    public void setExaminationWeight(String examinationWeight) {
        this.examinationWeight = examinationWeight;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
