package com.app.university.DTOs;

public class ScheduleDTO {

    private int scheduleId;
    private String day;
    private String startTime;
    private String endTime;
    private String location;
    private int courseId;
    private int professorId;

    // Default Constructor
    public ScheduleDTO() {
    }

    // Parameterized Constructor
    public ScheduleDTO(int scheduleId, String day, String startTime, String endTime, String location, int courseId, int professorId) {
        this.scheduleId = scheduleId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.courseId = courseId;
        this.professorId = professorId;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}