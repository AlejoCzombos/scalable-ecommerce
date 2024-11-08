package com.microservice.order.models.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    private Long id;
    private Long userId;
    private String status;
    private String totalPrice;
    private String createdAt;
    private String updatedAt;
    private List<OrderLineDto> lines;

}
