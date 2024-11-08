package com.microservice.order.models.request.order;

import com.microservice.order.models.request.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @NotNull(message = "User id is required")
    @NotEmpty(message = "User id is required")
    @NotBlank(message = "User id is required")
    private Long userId;

    @NotNull(message = "Payment method is required")
    private String paymentMethod;

    @NotEmpty(message = "You should provide at least one product to purchase")
    private List<PurchaseRequest> products;

}
