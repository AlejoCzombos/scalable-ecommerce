package com.microservice.order.controllers;

import com.microservice.order.models.dto.order.OrderDto;
import com.microservice.order.models.request.order.OrderRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/orders")
public interface OrderControllerAPI {

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    ResponseEntity<OrderDto> createOrder(
            @Valid
            @RequestBody
            OrderRequest request
    );

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    ResponseEntity<List<OrderDto>> getAllOrders();

    @RequestMapping(
            value = "/by-id/{id}",
            method = RequestMethod.GET
    )
    ResponseEntity<OrderDto> getOrderById(
            @PathVariable
            @NotNull(message = "Id is required")
            Long id
    );

}
