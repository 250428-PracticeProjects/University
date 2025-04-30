package com.app.university.repos;

import com.app.university.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {
    // Custom query method to find a professor by email
    Professor findByEmail(String email);
}