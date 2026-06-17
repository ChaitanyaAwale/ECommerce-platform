package com.Chaitanya.Project1.E_Commerce.platform.controller;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Order;
import com.Chaitanya.Project1.E_Commerce.platform.Service.OrderService;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping("place/{userId}")
    public OrderDto placeOrder(@PathVariable Long userId)
    {
         return orderService.placeOrder(userId);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId)
    {
        return orderService.getOrder(orderId);
    }
}
