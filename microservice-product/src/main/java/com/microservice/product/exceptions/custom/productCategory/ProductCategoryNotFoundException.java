package com.microservice.product.exceptions.custom.productCategory;

public class ProductCategoryNotFoundException extends RuntimeException {

    public final static String MESSAGE = "Product category not found ";

    public ProductCategoryNotFoundException(String message) {
        super(message);
    }

}
