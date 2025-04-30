package com.app.university.controllers;

import com.app.university.models.Schedule;
import com.app.university.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable int id, @RequestBody Schedule updatedSchedule) {
        return scheduleService.updateSchedule(id, updatedSchedule);
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable int id) {
        return scheduleService.getScheduleById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
    }
}