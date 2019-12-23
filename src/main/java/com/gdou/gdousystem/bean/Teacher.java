package com.gdou.gdousystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/21
 */
public class Teacher {
    private String teacherId;
    private String username;
    @JsonIgnore
    private String password;
    private String major;
    private boolean status;
    private String phone;
    private String department;
    private List<Role> role;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", major='" + major + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", role=" + role +
                '}';
    }
}
