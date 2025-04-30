package com.app.university.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents an enrollment of a student in a course.
 * This entity is mapped to the "enrollment" table in the database.
 * 
 * Fields:
 * - enrollmentId: The unique identifier for the enrollment.
 * - student: The student enrolled in the course (mapped to the User entity).
 * - course: The course the student is enrolled in (mapped to the Course
 * entity).
 * - enrollmentDate: The date and time when the enrollment occurred.
 * - grade: The grade the student received for the course (optional).
 * 
 * Annotations:
 * - @Entity: Marks this class as a JPA entity.
 * - @Table: Specifies the table name as "enrollment".
 * - @Id: Marks the primary key field.
 * - @GeneratedValue: Specifies that the primary key is auto-generated.
 * - @ManyToOne: Defines many-to-one relationships with the User and Course
 * entities.
 * - @JoinColumn: Specifies the foreign key columns as "userId" and "courseId".
 */
@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(name = "enrollment_date", nullable = false, updatable = false)
    private LocalDateTime enrollmentDate;

    @Column(name = "grade", nullable = true)
    private String grade;

    // Constructor
    public Enrollment(int id, User student, Course course, LocalDateTime enrollmentDate, String grade) {
        this.enrollmentId = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public Enrollment() {
    }

    // Getters and Setters
    public int getId() {
        return enrollmentId;
    }

    public void setId(int id) {
        this.enrollmentId = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + enrollmentId +
                ", student=" + student +
                ", course=" + course +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                '}';
    }
}
