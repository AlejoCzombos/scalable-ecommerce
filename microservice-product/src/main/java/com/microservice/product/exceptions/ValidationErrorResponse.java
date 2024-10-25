package com.microservice.product.exceptions;

import java.util.Map;

public record ValidationErrorResponse(
        Map<String, String> errors
) {

}

