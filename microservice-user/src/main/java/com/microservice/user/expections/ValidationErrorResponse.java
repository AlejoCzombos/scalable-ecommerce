package com.microservice.user.expections;

import java.util.Map;

public record ValidationErrorResponse(
        Map<String, String> errors
) {

}
