package com.app.university.services;

import com.app.university.models.User;
import com.app.university.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Update an existing user
    public User updateUser(int userId, User updatedUser) {
        User existingUser = userDAO.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userDAO.save(existingUser);
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // Retrieve a user by ID
    public User getUserById(int userId) {
        return userDAO.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Retrieve a user by email
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

}
