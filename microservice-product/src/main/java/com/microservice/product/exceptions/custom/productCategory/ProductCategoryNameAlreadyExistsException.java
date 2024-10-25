package com.microservice.product.exceptions.custom.productCategory;

public class ProductCategoryNameAlreadyExistsException extends RuntimeException {

    public final static String MESSAGE = "Product category name already exists ";

    public ProductCategoryNameAlreadyExistsException(String message) {
        super(message);
    }

}
