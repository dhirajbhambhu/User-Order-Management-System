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

}
