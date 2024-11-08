package com.microservice.order.mappers;

import com.microservice.order.models.dto.order.OrderLineDto;
import com.microservice.order.models.entities.Order;
import com.microservice.order.models.entities.OrderLine;
import com.microservice.order.models.request.order.OrderLineRequest;

public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.getId())
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .order(
                        Order.builder()
                                .id(request.getOrderId())
                                .build()
                )
                .build();
    }

    public OrderLineDto toOrderLineDto(OrderLine order){
        return OrderLineDto.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .build();
    }

}
