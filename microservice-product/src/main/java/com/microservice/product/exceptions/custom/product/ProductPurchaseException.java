package com.microservice.product.exceptions.custom.product;

public class ProductPurchaseException extends RuntimeException{

    public ProductPurchaseException(String message) {
        super(message);
    }
}
