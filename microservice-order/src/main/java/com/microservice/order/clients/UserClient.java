package com.microservice.order.clients;

import com.microservice.order.models.dto.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(
        name = "user-service",
        url = "${application.config.user-url}"
)
public interface UserClient {

    @RequestMapping(
            value = "/by-id/{id}",
            method = RequestMethod.GET
    )
    Optional<UserResponse> findUserById(@PathVariable Long id);

}
