package com.Chaitanya.Project1.E_Commerce.platform.controller;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Order;
import com.Chaitanya.Project1.E_Commerce.platform.Service.OrderService;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Checkout
    @PostMapping("/checkout")
    public OrderResponseDto checkout(@RequestParam Long userId) {
        return orderService.checkout(userId);
    }

    // Get all orders of a user
    @GetMapping
    public List<OrderResponseDto> getOrders(@RequestParam Long userId) {
        return orderService.getOrders(userId);
    }

    // Get a specific order
    @GetMapping("/{orderId}")
    public OrderResponseDto getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    // Cancel an order
    @PutMapping("/{orderId}/cancel")
    public OrderResponseDto cancelOrder(@PathVariable Long orderId) {
        return orderService.cancelOrder(orderId);
    }

}