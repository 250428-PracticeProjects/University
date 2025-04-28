package com.app.university.models;

/**
 * Represents a department in the university.
 * This entity is mapped to the "department" table in the database.
 * 
 * Fields:
 * - departmentId: The unique identifier for the department.
 * - name: The name of the department.
 * 
 * Annotations:
 * - @Entity: Marks this class as a JPA entity.
 * - @Table: Specifies the table name as "department".
 * - @Id: Marks the primary key field.
 * - @GeneratedValue: Specifies that the primary key is auto-generated.
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "name", nullable = false)
    private String name;

    // Default Constructor
    public Department() {
    }

    // Parameterized Constructor
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    // Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() Method
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }
}
