package com.microservice.order.services;

import com.microservice.order.models.dto.order.OrderLineDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderLineService {

    OrderLineDto saveOrderLine(OrderLineDto orderLineDto);

    List<OrderLineDto> getAllByOrderId(Integer orderId);

}
