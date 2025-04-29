package com.app.university.services;

import com.app.university.DTOs.UserDTO;
import com.app.university.models.User;
import com.app.university.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    /**
     * Logs in a user by validating their credentials.
     * 
     * @param userCredentials The user's login credentials.
     * @return An Optional containing the UserDTO of the logged-in user.
     * @throws GenericException if the user is not found or the password is
     *                          incorrect.
     */
    public Optional<UserDTO> login(User userCredentials) {
        Optional<User> user = userDAO.findByEmail(userCredentials.getEmail());
        User userToLogin;

        if (user.isEmpty()) {
            throw new GenericException("User not found with the Email");
        } else {
            userToLogin = user.get();
        }

        if (!PasswordUtil.checkPassword(userToLogin.getPasswordHash(), userCredentials.getPasswordHash())) {
            throw new GenericException("Incorrect Password");
        }
        UserDTO userDTO = new UserDTO(userToLogin.getUserId(), userToLogin.getEmail(), userToLogin.getName(),
                userToLogin.getRole());
        return Optional.of(userDTO);
    }

}
