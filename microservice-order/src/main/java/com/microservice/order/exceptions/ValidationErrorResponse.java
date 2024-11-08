package com.microservice.order.exceptions;

import java.util.Map;

public record ValidationErrorResponse(
        Map<String, String> errors
) {

}

