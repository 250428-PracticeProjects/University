package com.app.university.controllers;

import com.app.university.models.Professor;
import com.app.university.services.ProfessorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfessorControllerTest {

    @Mock
    private ProfessorService professorService;

    @InjectMocks
    private ProfessorController professorController;

    @Test
    void createProfessor_Success() {
        Professor professor = new Professor();
        professor.setName("John Doe");

        when(professorService.createProfessor(professor)).thenReturn(professor);

        Professor createdProfessor = professorController.createProfessor(professor);

        assertNotNull(createdProfessor);
        assertEquals("John Doe", createdProfessor.getName());
        verify(professorService, times(1)).createProfessor(professor);
    }

    @Test
    void getAllProfessors_Success() {
        Professor professor1 = new Professor();
        Professor professor2 = new Professor();
        List<Professor> professors = Arrays.asList(professor1, professor2);

        when(professorService.getAllProfessors()).thenReturn(professors);

        List<Professor> result = professorController.getAllProfessors();

        assertEquals(2, result.size());
        verify(professorService, times(1)).getAllProfessors();
    }
}