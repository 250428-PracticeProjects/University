package com.app.university.services;

import com.app.university.models.Professor;
import com.app.university.repos.ProfessorDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfessorServiceTest {

    @Mock
    private ProfessorDAO professorDAO;

    @InjectMocks
    private ProfessorService professorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProfessor_Success() {
        Professor professor = new Professor();
        professor.setName("John Doe");
        professor.setEmail("john.doe@example.com");

        when(professorDAO.findByEmail(professor.getEmail())).thenReturn(null);
        when(professorDAO.save(professor)).thenReturn(professor);

        Professor createdProfessor = professorService.createProfessor(professor);

        assertNotNull(createdProfessor);
        assertEquals("John Doe", createdProfessor.getName());
        verify(professorDAO, times(1)).save(professor);
    }

    @Test
    void createProfessor_EmailAlreadyExists_ThrowsException() {
        Professor professor = new Professor();
        professor.setEmail("john.doe@example.com");

        when(professorDAO.findByEmail(professor.getEmail())).thenReturn(professor);

        assertThrows(RuntimeException.class, () -> professorService.createProfessor(professor));
        verify(professorDAO, never()).save(any());
    }

    @Test
    void getProfessorById_Success() {
        Professor professor = new Professor();
        professor.setProfessorId(1);
        professor.setName("John Doe");

        when(professorDAO.findById(1)).thenReturn(Optional.of(professor));

        Professor foundProfessor = professorService.getProfessorById(1);

        assertNotNull(foundProfessor);
        assertEquals(1, foundProfessor.getProfessorId());
        verify(professorDAO, times(1)).findById(1);
    }

    @Test
    void getProfessorById_NotFound_ThrowsException() {
        when(professorDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> professorService.getProfessorById(1));
        verify(professorDAO, times(1)).findById(1);
    }
}