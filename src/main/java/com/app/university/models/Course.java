package com.app.university.models;

/**
 * Represents a course offered by the university.
 * This entity is mapped to the "course" table in the database.
 * 
 * Fields:
 * - courseId: The unique identifier for the course.
 * - name: The name of the course.
 * - credits: The number of credits the course is worth.
 * - department: The department offering the course (mapped to the Department entity).
 * 
 * Annotations:
 * - @Entity: Marks this class as a JPA entity.
 * - @Table: Specifies the table name as "course".
 * - @Id: Marks the primary key field.
 * - @GeneratedValue: Specifies that the primary key is auto-generated.
 * - @ManyToOne: Defines a many-to-one relationship with the Department entity.
 * - @JoinColumn: Specifies the foreign key column as "department_id".
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "credits", nullable = false)
    private int credits;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Default Constructor
    public Course() {
    }

    // Parameterized Constructor
    public Course(int courseId, String name, int credits, Department department) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // toString() Method
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                '}';
    }
}
