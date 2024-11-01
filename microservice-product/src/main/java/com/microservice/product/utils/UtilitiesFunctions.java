package com.microservice.product.utils;

public class UtilitiesFunctions {

    public static boolean isInvalidPageRequest(int page, int size) {
        return (page < 0 || size < 0 || size > 50);
    }

}
