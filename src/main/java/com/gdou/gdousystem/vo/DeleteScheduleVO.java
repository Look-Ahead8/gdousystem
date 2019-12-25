package com.gdou.gdousystem.vo;

import javax.validation.constraints.NotBlank;

/**
 * @author Meng
 * @date 2019/12/24
 */
public class DeleteScheduleVO {
    @NotBlank(message = "班级不可以为空")
    private String studentClass;
    @NotBlank(message = "教师号不可以为空")
    private String teacherId;
    @NotBlank(message = "版本号不可以为空")
    private String version;
    @NotBlank(message = "学期不可以为空")
    private String term;

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
}
