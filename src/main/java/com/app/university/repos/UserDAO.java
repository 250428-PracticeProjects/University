package com.app.university.repos;

import com.app.university.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    // Custom query methods can be added here if needed
    User findByEmail(String email);
}
