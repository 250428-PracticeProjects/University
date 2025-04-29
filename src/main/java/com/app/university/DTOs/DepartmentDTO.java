package com.app.university.DTOs;

public class DepartmentDTO {

    private int departmentId;
    private String name;

    // Default Constructor
    public DepartmentDTO() {
    }

    // Parameterized Constructor
    public DepartmentDTO(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    // Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}