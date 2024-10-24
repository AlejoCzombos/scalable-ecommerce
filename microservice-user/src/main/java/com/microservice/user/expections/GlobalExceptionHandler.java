package com.microservice.user.expections;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ValidationErrorResponse handleValidationErrors(HttpServletRequest request, MethodArgumentNotValidException e){

        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return new ValidationErrorResponse(errors);
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(EmailAlreadyExistsException.class)
    MessageException handleEmailAlreadyExistsException(HttpServletRequest request, EmailAlreadyExistsException e) {
        return MessageException.builder()
                .message(e.getMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    MessageException handleUserNotFoundException(HttpServletRequest request, UserNotFoundException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    MessageException handleBadCredentialException(HttpServletRequest request, AccessDeniedException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    MessageException handleBadCredentialException(HttpServletRequest request, BadCredentialsException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    MessageException handleAuthenticationException(HttpServletRequest request, AuthenticationException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    MessageException handleGenericException(HttpServletRequest request){
        return MessageException.builder()
                .message("Internal server error")
                .uri(request.getRequestURI())
                .build();
    }

}