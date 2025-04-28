package com.app.university.services;

import com.app.university.models.User;
import com.app.university.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserDAO userDAO;

    @Autowired
    public AdminService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Create a new user
    public User createUser(User user) {
        return userDAO.save(user);
    }

    // Update user information
    public User updateUser(int userId, User updatedUser) {
        User existingUser = userDAO.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setRole(updatedUser.getRole());
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

    // Delete a user
    public void deleteUser(int userId) {
        userDAO.deleteById(userId);
    }

    public Page<User> getAllUsers(PageRequest pageRequest) {
        return userDAO.findAll(pageRequest);
    }
}
