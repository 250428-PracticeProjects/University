package com.app.university.repos;

import com.app.university.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Integer> {
    // Custom query methods can be added here if needed
    Department findByName(String name);
}