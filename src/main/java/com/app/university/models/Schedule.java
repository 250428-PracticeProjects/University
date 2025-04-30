package com.app.university.models;

/**
 * Represents a schedule for a course in the university.
 * This entity is mapped to the "schedule" table in the database.
 * 
 * Fields:
 * - scheduleId: The unique identifier for the schedule.
 * - day: The day of the week for the schedule (e.g., Monday, Tuesday).
 * - startTime: The start time of the schedule.
 * - endTime: The end time of the schedule.
 * - location: The location where the course is held.
 * - course: The course associated with the schedule (mapped to the Course entity).
 * - professor: The professor teaching the course (mapped to the Professor entity).
 * 
 * Annotations:
 * - @Entity: Marks this class as a JPA entity.
 * - @Table: Specifies the table name as "schedule".
 * - @Id: Marks the primary key field.
 * - @GeneratedValue: Specifies that the primary key is auto-generated.
 * - @ManyToOne: Defines many-to-one relationships with the Course and Professor entities.
 * - @JoinColumn: Specifies the foreign key columns as "course_id" and "professor_id".
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
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int scheduleId;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    // Default Constructor
    public Schedule() {
    }

    // Parameterized Constructor
    public Schedule(int scheduleId, String day, String startTime, String endTime, String location, Course course, Professor professor) {
        this.scheduleId = scheduleId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.course = course;
        this.professor = professor;
    }

    // Getters and Setters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // toString() Method
    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", day='" + day + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", location='" + location + '\'' +
                ", course=" + course +
                ", professor=" + professor +
                '}';
    }
}
