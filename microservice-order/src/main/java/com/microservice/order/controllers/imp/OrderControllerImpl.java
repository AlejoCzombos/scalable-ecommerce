package com.microservice.order.controllers.imp;

import com.microservice.order.controllers.OrderControllerAPI;
import com.microservice.order.models.dto.order.OrderDto;
import com.microservice.order.models.request.order.OrderRequest;
import com.microservice.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderControllerAPI {

    private final OrderService service;

    @Override
    public ResponseEntity<OrderDto> createOrder(OrderRequest request) {
        return new ResponseEntity<>(service.createOrder(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(service.getAllOrders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> getOrderById(Long id) {
        return new ResponseEntity<>(service.getOrderById(id), HttpStatus.OK);
    }
}
