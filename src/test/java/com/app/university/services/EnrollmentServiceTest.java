package com.app.university.services;

import com.app.university.models.Enrollment;
import com.app.university.repos.EnrollmentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnrollmentServiceTest {

    @Mock
    private EnrollmentDAO enrollmentDAO;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEnrollment_Success() {
        Enrollment enrollment = new Enrollment();
        when(enrollmentDAO.save(enrollment)).thenReturn(enrollment);

        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);

        assertNotNull(createdEnrollment);
        verify(enrollmentDAO, times(1)).save(enrollment);
    }

    @Test
    void deleteEnrollment_Success() {
        when(enrollmentDAO.existsById(1)).thenReturn(true);

        enrollmentService.deleteEnrollment(1);

        verify(enrollmentDAO, times(1)).deleteById(1);
    }

    @Test
    void deleteEnrollment_NotFound_ThrowsException() {
        when(enrollmentDAO.existsById(1)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> enrollmentService.deleteEnrollment(1));
        verify(enrollmentDAO, never()).deleteById(1);
    }
}