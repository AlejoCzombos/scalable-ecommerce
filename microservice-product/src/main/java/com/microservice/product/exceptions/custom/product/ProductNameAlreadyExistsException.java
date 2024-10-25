package com.microservice.product.exceptions.custom.product;

public class ProductNameAlreadyExistsException extends RuntimeException {

    public final static String MESSAGE = "Product name already exists ";

    public ProductNameAlreadyExistsException(String message) {
        super(message);
    }

}
