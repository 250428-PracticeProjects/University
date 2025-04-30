package com.app.university.services;

import com.app.university.models.Course;
import com.app.university.repos.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    // Create a new course
    public Course createCourse(Course course) {
        return courseDAO.save(course);
    }

    // Update an existing course
    public Course updateCourse(int courseId, Course updatedCourse) {
        Course existingCourse = courseDAO.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        existingCourse.setName(updatedCourse.getName());
        existingCourse.setCredits(updatedCourse.getCredits());
        existingCourse.setDepartment(updatedCourse.getDepartment());
        return courseDAO.save(existingCourse);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseDAO.findAll();
    }

    // Retrieve a course by ID
    public Course getCourseById(int courseId) {
        return courseDAO.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    // Delete a course by ID
    public void deleteCourse(int courseId) {
        if (!courseDAO.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }
        courseDAO.deleteById(courseId);

    }

}
