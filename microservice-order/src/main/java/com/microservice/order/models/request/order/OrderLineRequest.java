package com.microservice.order.models.request.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLineRequest {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Long orderId;
}
