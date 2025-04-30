package com.app.university.services;

import com.app.university.models.Schedule;
import com.app.university.repos.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleDAO scheduleDAO;

    @Autowired
    public ScheduleService(ScheduleDAO scheduleDAO) {
        this.scheduleDAO = scheduleDAO;
    }

    // Create a new schedule
    public Schedule createSchedule(Schedule schedule) {
        return scheduleDAO.save(schedule);
    }

    // Update an existing schedule
    public Schedule updateSchedule(int scheduleId, Schedule updatedSchedule) {
        Schedule existingSchedule = scheduleDAO.findById(scheduleId).orElseThrow(() -> new RuntimeException("Schedule not found"));
        existingSchedule.setDay(updatedSchedule.getDay());
        existingSchedule.setStartTime(updatedSchedule.getStartTime());
        existingSchedule.setEndTime(updatedSchedule.getEndTime());
        existingSchedule.setLocation(updatedSchedule.getLocation());
        existingSchedule.setCourse(updatedSchedule.getCourse());
        existingSchedule.setProfessor(updatedSchedule.getProfessor());
        return scheduleDAO.save(existingSchedule);
    }

    // Retrieve all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleDAO.findAll();
    }

    // Retrieve a schedule by ID
    public Schedule getScheduleById(int scheduleId) {
        return scheduleDAO.findById(scheduleId).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    // Delete a schedule by ID
    public void deleteSchedule(int scheduleId) {
        if (!scheduleDAO.existsById(scheduleId)) {
            throw new RuntimeException("Schedule not found");
        }
        scheduleDAO.deleteById(scheduleId);
    }
}
