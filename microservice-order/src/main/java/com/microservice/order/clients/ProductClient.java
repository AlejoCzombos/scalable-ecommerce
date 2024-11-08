package com.microservice.order.clients;

import com.microservice.order.models.dto.product.ProductResponse;
import com.microservice.order.models.request.product.PurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "product-service",
        url = "${application.config.product-url}"
)
public interface ProductClient {

    @RequestMapping(
            value = "/purchase",
            method = RequestMethod.GET
    )
    ResponseEntity<ProductResponse> purchaseProducts(@RequestBody List<PurchaseRequest> purchase);

}
