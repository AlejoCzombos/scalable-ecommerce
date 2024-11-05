package com.microservice.product.models.request.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderBy {

    private boolean ascending;
    private String field;

}
