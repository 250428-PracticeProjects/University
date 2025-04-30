package com.app.university.services;

import com.app.university.models.Department;
import com.app.university.repos.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    // Create a new department
    public Department createDepartment(Department department) {
        return departmentDAO.save(department);
    }

    // Update an existing department
    public Department updateDepartment(int departmentId, Department updatedDepartment) {
        Department existingDepartment = departmentDAO.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        existingDepartment.setName(updatedDepartment.getName());
        return departmentDAO.save(existingDepartment);
    }

    // Retrieve all departments
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    // Retrieve a department by ID
    public Department getDepartmentById(int departmentId) {
        return departmentDAO.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    // Delete a department by ID
    public void deleteDepartment(int departmentId) {
        if (!departmentDAO.existsById(departmentId)) {
            throw new RuntimeException("Department not found");
        }
        departmentDAO.deleteById(departmentId);
    }
}
