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

import java.util.List;

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
    @GetMapping("/{userId}/orders")
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getOrdersByUserId(
            @PathVariable int userId) {

        List<OrderResponseDto> orders =
                orderService.getOrdersByUserId(userId);

        ApiResponse<List<OrderResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Orders fetched successfully",
                        orders
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDto>> getOrderById(
            @PathVariable int id) {

        OrderResponseDto order =
                orderService.getOrderById(id);

        ApiResponse<OrderResponseDto> response =
                new ApiResponse<>(
                        true,
                        "Order found",
                        order
                );

        return ResponseEntity.ok(response);
    }
    @PutMapping("/orders/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDto>> updateOrder(
            @PathVariable int id,
            @RequestBody OrderRequestDto orderRequestDto) {

        OrderResponseDto updatedOrder =
                orderService.updateOrder(id, orderRequestDto);

        ApiResponse<OrderResponseDto> response =
                new ApiResponse<>(
                        true,
                        "Order updated successfully",
                        updatedOrder
                );

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<ApiResponse<String>> deleteOrder(
            @PathVariable int id) {

        orderService.deleteOrder(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        true,
                        "Order deleted successfully",
                        null
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/orders/search")
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> searchOrdersByProduct(
            @RequestParam String productName) {

        List<OrderResponseDto> orders =
                orderService.searchOrdersByProduct(productName);

        ApiResponse<List<OrderResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Orders found successfully",
                        orders
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/orders/above-price")
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getOrdersAbovePrice(
            @RequestParam double price) {

        List<OrderResponseDto> orders =
                orderService.getOrdersAbovePrice(price);

        ApiResponse<List<OrderResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Orders fetched successfully",
                        orders
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/orders/between-prices")
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getOrdersBetweenPrices(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {

        List<OrderResponseDto> orders =
                orderService.getOrdersBetweenPrices(
                        minPrice,
                        maxPrice
                );

        ApiResponse<List<OrderResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Orders fetched successfully",
                        orders
                );

        return ResponseEntity.ok(response);
    }

}