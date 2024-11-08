package com.microservice.order.services.imp;

import com.microservice.order.clients.ProductClient;
import com.microservice.order.clients.UserClient;
import com.microservice.order.exceptions.custom.user.UserNotFoundException;
import com.microservice.order.mappers.OrderMapper;
import com.microservice.order.models.dto.order.OrderDto;
import com.microservice.order.models.dto.product.ProductResponse;
import com.microservice.order.models.dto.user.UserResponse;
import com.microservice.order.models.entities.Order;
import com.microservice.order.models.request.order.OrderRequest;
import com.microservice.order.repositories.OrderRepository;
import com.microservice.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserClient userClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Override
    @Transactional
    public OrderDto createOrder(OrderRequest request) {
        UserResponse user = userClient.findUserById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException(UserNotFoundException.MESSAGE + "with id: " + request.getUserId()));

        System.out.println("User found: " + user.toString());

        ProductResponse purchasedProducts = productClient.purchaseProducts(request.getProducts()).getBody();

        System.out.println("Products purchased: " + purchasedProducts.toString());

        Order savedOrder = repository.save(mapper.toOrder(request));

        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return null;
    }
}
