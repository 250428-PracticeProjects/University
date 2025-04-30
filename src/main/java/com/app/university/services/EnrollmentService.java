package com.app.university.services;

import com.app.university.models.Enrollment;
import com.app.university.repos.EnrollmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentDAO enrollmentDAO;

    @Autowired
    public EnrollmentService(EnrollmentDAO enrollmentDAO) {
        this.enrollmentDAO = enrollmentDAO;
    }

    // Create a new enrollment
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentDAO.save(enrollment);
    }

    // Retrieve all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentDAO.findAll();
    }

    // Retrieve enrollments by student ID
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return enrollmentDAO.findByStudentUserId(studentId);
    }

    // Retrieve enrollments by course ID
    public List<Enrollment> getEnrollmentsByCourseId(int courseId) {
        return enrollmentDAO.findByCourseCourseId(courseId);
    }

    // Delete an enrollment by ID
    public void deleteEnrollment(int enrollmentId) {
        if (!enrollmentDAO.existsById(enrollmentId)) {
            throw new RuntimeException("Enrollment not found");
        }
        enrollmentDAO.deleteById(enrollmentId);
    }
}
