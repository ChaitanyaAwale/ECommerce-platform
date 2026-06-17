package com.Chaitanya.Project1.E_Commerce.platform.Service;


import com.Chaitanya.Project1.E_Commerce.platform.Entity.*;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderDto;
import com.Chaitanya.Project1.E_Commerce.platform.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class OrderService {
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    public  OrderDto getOrder(Long orderId) {

        Order order=orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("No order found"));
      OrderDto dto=modelMapper.map(order, OrderDto.class);
      return dto;
    }

    @Transactional
    public OrderDto placeOrder(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("No user found"));

        Cart cart = cartRepository.findByUser_Id(userId).orElseThrow(() -> new RuntimeException("No cart found"));

        if (cart.getCartItems().isEmpty()) {
            throw new RuntimeException("cart is Empty");

        }

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (CartItem item : cart.getCartItems()) {
            BigDecimal itemtotal = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            totalAmount = totalAmount.add(itemtotal);
        }

        Order order = Order.builder().
                user(user)
                .orderDate(LocalDateTime.now())
                .totalAmount(totalAmount)
                .status("PLACED")
                .build();
        order = orderRepository.save(order);

        for (CartItem item : cart.getCartItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(item.getProduct())
                    .quantity(item.getQuantity())
                    .price(BigDecimal.valueOf(item.getProduct().getPrice().doubleValue()))
                    .build();

            orderItemRepository.save(orderItem);


        }
        cart.getCartItems().clear();

        OrderDto dto=modelMapper.map(order, OrderDto.class);
        return dto;

    }
}
