package com.gdou.gdousystem.vo;

import javax.validation.constraints.NotBlank;

/**
 * @author Meng
 * @date 2019/12/24
 */
public class ScheduleVO {
    @NotBlank(message = "版本号不可以为空")
    private String version;
    @NotBlank(message = "课程号不可以为空")
    private String courseId;
    @NotBlank(message = "教师号不可以为空")
    private String teacherId;
    @NotBlank(message = "学期不可以为空")
    private String term;
    @NotBlank(message = "院系不可以为空")
    private String department;
    @NotBlank(message = "专业不可以为空")
    private String major;
    @NotBlank(message = "班级不可以为空")
    private String studentClass;
    private String studentId;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
