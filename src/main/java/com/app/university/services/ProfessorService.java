package com.app.university.services;

import com.app.university.models.Professor;
import com.app.university.repos.ProfessorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorDAO professorDAO;

    @Autowired
    public ProfessorService(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    // Create a new professor
    public Professor createProfessor(Professor professor) {
        if (professorDAO.findByEmail(professor.getEmail()) != null) {
            throw new RuntimeException("A professor with this email already exists");
        }
        return professorDAO.save(professor);
    }

    // Update an existing professor
    public Professor updateProfessor(int professorId, Professor updatedProfessor) {
        Professor existingProfessor = professorDAO.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        if (!existingProfessor.getEmail().equals(updatedProfessor.getEmail()) &&
                professorDAO.findByEmail(updatedProfessor.getEmail()) != null) {
            throw new RuntimeException("A professor with this email already exists");
        }

        existingProfessor.setName(updatedProfessor.getName());
        existingProfessor.setDepartment(updatedProfessor.getDepartment());
        existingProfessor.setEmail(updatedProfessor.getEmail());
        return professorDAO.save(existingProfessor);
    }

    // Retrieve all professors
    public List<Professor> getAllProfessors() {
        return professorDAO.findAll();
    }

    // Retrieve a professor by ID
    public Professor getProfessorById(int professorId) {
        return professorDAO.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    // Delete a professor by ID
    public void deleteProfessor(int professorId) {
        if (!professorDAO.existsById(professorId)) {
            throw new RuntimeException("Professor not found");
        }
        professorDAO.deleteById(professorId);
    }
}
