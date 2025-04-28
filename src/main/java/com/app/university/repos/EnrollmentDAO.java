package com.app.university.repos;

import com.app.university.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentDAO extends JpaRepository<Enrollment, Integer> {
    // Custom query methods can be added here if needed
    List<Enrollment> findByStudentUserId(int userId);
    List<Enrollment> findByCourseCourseId(int courseId);
}
