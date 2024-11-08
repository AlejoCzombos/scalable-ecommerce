package com.microservice.order.services;

import com.microservice.order.models.dto.order.OrderDto;
import com.microservice.order.models.request.order.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    OrderDto createOrder(OrderRequest orderRequest);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long id);

}
