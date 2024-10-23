package com.microservice.user.expections;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class MessageException {
    private String message;
    private String uri;
}
