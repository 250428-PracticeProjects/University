package com.app.university.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException passwordIncorrect() {
        return new UserNotFoundException("Password is incorrect.");
    }
}
