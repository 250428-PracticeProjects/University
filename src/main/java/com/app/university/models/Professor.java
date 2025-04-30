package com.app.university.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private int professorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Default Constructor
    public Professor() {
    }

    // Parameterized Constructor
    public Professor(int professorId, String name, String department, String email) {
        this.professorId = professorId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Getters and Setters
    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString() Method
    @Override
    public String toString() {
        return "Professor{" +
                "professorId=" + professorId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
