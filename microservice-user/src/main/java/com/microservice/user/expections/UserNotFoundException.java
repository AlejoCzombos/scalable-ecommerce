package com.microservice.user.expections;

public class UserNotFoundException extends RuntimeException{

    public final static String MESSAGE_USER_NOT_FOUND = "User not found ";

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
