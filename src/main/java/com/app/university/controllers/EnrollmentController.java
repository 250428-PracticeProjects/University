package com.app.university.controllers;

import com.app.university.models.Enrollment;
import com.app.university.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable int studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourseId(@PathVariable int courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEnrollment(@PathVariable int id) {
        enrollmentService.deleteEnrollment(id);
    }
}