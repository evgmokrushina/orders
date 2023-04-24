package ru.jenia.pojo;

import java.time.LocalDate;

public class Student {
    private String fullName;
    private String group;
    private LocalDate enrollment;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(LocalDate enrollment) {
        this.enrollment = enrollment;
    }
}
