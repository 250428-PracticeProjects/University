package com.app.university.DTOs;

public class CourseDTO {

    private int courseId;
    private String name;
    private int credits;
    private int departmentId;

    // Default Constructor
    public CourseDTO() {
    }

    // Parameterized Constructor
    public CourseDTO(int courseId, String name, int credits, int departmentId) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}