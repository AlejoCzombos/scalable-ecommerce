package com.microservice.order.exceptions;

import com.microservice.order.exceptions.custom.product.ProductNotFoundException;
import com.microservice.order.exceptions.custom.user.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    MessageException handleUserNotFoundException(HttpServletRequest request, UserNotFoundException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    MessageException handleProductNotFoundException(HttpServletRequest request, ProductNotFoundException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    MessageException handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e){
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
