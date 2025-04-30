package com.app.university.controllers;

import com.app.university.models.User;
import com.app.university.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return adminService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return adminService.updateUser(id, updatedUser);
    }

    @GetMapping("/users")
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return adminService.getAllUsers(PageRequest.of(page, size));
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return adminService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        adminService.deleteUser(id);
    }
}