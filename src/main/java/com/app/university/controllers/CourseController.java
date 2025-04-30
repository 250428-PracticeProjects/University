package com.app.university.controllers;

import com.app.university.models.Course;
import com.app.university.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}