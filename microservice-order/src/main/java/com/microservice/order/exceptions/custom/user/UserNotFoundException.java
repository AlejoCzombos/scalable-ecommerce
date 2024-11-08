package com.microservice.order.exceptions.custom.user;

public class UserNotFoundException extends RuntimeException {

    public final static String MESSAGE = "User not found ";

    public UserNotFoundException(String message) {
        super(message);
    }
}
