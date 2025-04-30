package com.app.university.models;

/**
 * Represents a user in the university system.
 * This entity is mapped to the "user" table in the database.
 * 
 * Fields:
 * - userId: The unique identifier for the user.
 * - name: The name of the user.
 * - email: The email address of the user (must be unique).
 * - password: The password of the user.
 * - role: The role of the user (e.g., student, admin, professor).
 * 
 * Annotations:
 * - @Entity: Marks this class as a JPA entity.
 * - @Table: Specifies the table name as "user".
 * - @Id: Marks the primary key field.
 * - @GeneratedValue: Specifies that the primary key is auto-generated.
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserType role;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(int userId, String name, String email, String password, UserType role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

    // toString() Method
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
