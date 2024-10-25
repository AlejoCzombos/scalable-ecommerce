package com.microservice.product.exceptions.custom.product;

public class ProductNotFoundException extends RuntimeException {

    public final static String MESSAGE = "Product not found ";

    public ProductNotFoundException(String message) {
        super(message);
    }
}
