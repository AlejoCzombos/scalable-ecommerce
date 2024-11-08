package com.microservice.order.mappers;

import com.microservice.order.models.dto.order.OrderDto;
import com.microservice.order.models.entities.Order;
import com.microservice.order.models.enums.PaymentMethod;
import com.microservice.order.models.request.order.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request){
        return Order.builder()
                .userId(request.getUserId())
                .paymentMethod(PaymentMethod.valueOf(request.getPaymentMethod()))
                .build();
    }

    public OrderDto toOrderDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .status(order.getStatus().name())
                .totalPrice(order.getTotalPrice().toString())
                .createdAt(order.getCreatedAt().toString())
                .updatedAt(order.getUpdatedAt().toString())
                .build();
    }

}
