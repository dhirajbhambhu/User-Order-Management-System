package com.dheeraj.usermanagement.controller;
import com.dheeraj.usermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dheeraj.usermanagement.dto.OrderRequestDto;
import com.dheeraj.usermanagement.dto.OrderResponseDto;
import com.dheeraj.usermanagement.response.ApiResponse;
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/{userId}/orders")
    public ResponseEntity<ApiResponse<OrderResponseDto>> createOrder(
            @PathVariable int userId,
            @RequestBody OrderRequestDto orderRequestDto) {

        OrderResponseDto savedOrder =
                orderService.createOrder(userId, orderRequestDto);

        ApiResponse<OrderResponseDto> response =
                new ApiResponse<>(
                        true,
                        "Order Created Successfully",
                        savedOrder
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}