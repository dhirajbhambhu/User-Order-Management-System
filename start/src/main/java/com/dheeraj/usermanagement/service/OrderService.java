package com.dheeraj.usermanagement.service;
import com.dheeraj.usermanagement.dto.OrderResponseDto;
import com.dheeraj.usermanagement.repository.OrderRepository;
import com.dheeraj.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dheeraj.usermanagement.dto.OrderRequestDto;
import com.dheeraj.usermanagement.exception.UserNotFoundException;
import com.dheeraj.usermanagement.model.Orders;
import com.dheeraj.usermanagement.model.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    public OrderResponseDto createOrder(
            int userId,
            OrderRequestDto orderRequestDto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        Orders order = new Orders();

        order.setProductName(orderRequestDto.getProductName());
        order.setPrice(orderRequestDto.getPrice());

        order.setUser(user);

        Orders savedOrder = orderRepository.save(order);

        return new OrderResponseDto(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getPrice()
        );
    }
    public List<OrderResponseDto> getOrdersByUserId(int userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        List<Orders> orders = orderRepository.findByUserId(userId);

        return orders.stream()
                .map(order -> new OrderResponseDto(
                        order.getId(),
                        order.getProductName(),
                        order.getPrice()
                ))
                .toList();
    }
    public OrderResponseDto getOrderById(int id) {

        Orders order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        return new OrderResponseDto(
                order.getId(),
                order.getProductName(),
                order.getPrice()
        );
    }
    public OrderResponseDto updateOrder(
            int id,
            OrderRequestDto orderRequestDto) {

        Orders order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        order.setProductName(
                orderRequestDto.getProductName());

        order.setPrice(
                orderRequestDto.getPrice());

        Orders updatedOrder =
                orderRepository.save(order);

        return new OrderResponseDto(
                updatedOrder.getId(),
                updatedOrder.getProductName(),
                updatedOrder.getPrice()
        );
    }
    public void deleteOrder(int id) {

        Orders order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        orderRepository.delete(order);
    }
    public List<OrderResponseDto> searchOrdersByProduct(String productName) {

        List<Orders> orders =
                orderRepository.findByProductNameContainingIgnoreCase(productName);

        return orders.stream()
                .map(order -> new OrderResponseDto(
                        order.getId(),
                        order.getProductName(),
                        order.getPrice()
                ))
                .toList();
    }

}
