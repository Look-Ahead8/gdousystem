package com.gdou.gdousystem.vo;

import javax.validation.constraints.NotBlank;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class GetExcelVO {
    @NotBlank(message = "课程号不可以为空")
    private String courseId;
    @NotBlank(message = "版本号不可以为空")
    private String version;
    @NotBlank(message = "学期不可以为空")
    private String term;
    @NotBlank(message = "学生班级不可以为空")
    private String studentClass;
    private String teacherId;

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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
