package com.app.university.controllers;

import com.app.university.models.Professor;
import com.app.university.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable int id, @RequestBody Professor updatedProfessor) {
        return professorService.updateProfessor(id, updatedProfessor);
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable int id) {
        return professorService.getProfessorById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfessor(@PathVariable int id) {
        professorService.deleteProfessor(id);
    }
}