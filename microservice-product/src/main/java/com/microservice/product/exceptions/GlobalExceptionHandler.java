package com.microservice.product.exceptions;

import com.microservice.product.exceptions.custom.product.ProductNameAlreadyExistsException;
import com.microservice.product.exceptions.custom.product.ProductNotFoundException;
import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNameAlreadyExistsException;
import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNotFoundException;
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

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    MessageException handleProductNotFoundException(HttpServletRequest request, ProductNotFoundException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductCategoryNotFoundException.class)
    MessageException handleProductCategoryNotFoundException(HttpServletRequest request, ProductCategoryNotFoundException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNameAlreadyExistsException.class)
    MessageException handleProductNameAlreadyExistsException(HttpServletRequest request, ProductNameAlreadyExistsException e){
        return MessageException.builder()
                .message(e.getLocalizedMessage())
                .uri(request.getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductCategoryNameAlreadyExistsException.class)
    MessageException handleProductCategoryNameAlreadyExistsException(HttpServletRequest request, ProductCategoryNameAlreadyExistsException e){
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
