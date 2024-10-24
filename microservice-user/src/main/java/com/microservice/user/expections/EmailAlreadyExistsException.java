package com.microservice.user.expections;

public class EmailAlreadyExistsException extends RuntimeException {

        public final static String MESSAGE_EMAIL_ALREADY_EXISTS = "Email already exists ";

        public EmailAlreadyExistsException(String message) {
            super(message);
        }

        public EmailAlreadyExistsException(String message, Throwable cause) {
            super(message, cause);
        }
}
