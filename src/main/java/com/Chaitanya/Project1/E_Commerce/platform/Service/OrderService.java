package com.Chaitanya.Project1.E_Commerce.platform.Service;


import com.Chaitanya.Project1.E_Commerce.platform.Entity.*;
import com.Chaitanya.Project1.E_Commerce.platform.Enum.OrderStatus;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderItemResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.OrderResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.exceptions.ResourceNotFoundException;
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
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderResponseDto checkout(Long userId) {

        // Find User
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        // Find Cart
        Cart cart = cartRepository.findByUser_Id(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found"));

        // Empty Cart Check
        if (cart.getCartItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // Create Order
        Order order = new Order();

        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        BigDecimal total = BigDecimal.ZERO;

        List<OrderItem> orderItems = new ArrayList<>();

        // Convert CartItems -> OrderItems
        for (CartItem cartItem : cart.getCartItems()) {

            Product product = cartItem.getProduct();

            // Stock Validation
            if (product.getStockQuantity() < cartItem.getQuantity()) {
                throw new RuntimeException(
                        product.getName() + " is out of stock"
                );
            }

            // Reduce Stock
            product.setStockQuantity(
                    product.getStockQuantity() - cartItem.getQuantity()
            );

            productRepository.save(product);

            // Create OrderItem
            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);

            orderItem.setProduct(product);

            orderItem.setQuantity(cartItem.getQuantity());

            orderItem.setPrice(product.getPrice());

            orderItems.add(orderItem);

            // Calculate Total
            BigDecimal itemTotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(cartItem.getQuantity()));

            total = total.add(itemTotal);
        }

        order.setOrderItems(orderItems);

        order.setTotalAmount(total);

        // Save Order
        Order savedOrder = orderRepository.save(order);

        // Clear Cart
        cart.getCartItems().clear();

        cartRepository.save(cart);

        // Convert Entity -> DTO
        return convertToDto(savedOrder);
    }


    public List<OrderResponseDto> getOrders(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return orderRepository.findByUser(user)
                .stream()
                .map(this::convertToDto)
                .toList();
    }


    public OrderResponseDto getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));

        return convertToDto(order);
    }


    public OrderResponseDto cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));

        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new RuntimeException(
                    "Delivered order cannot be cancelled"
            );
        }

        order.setStatus(OrderStatus.CANCELLED);

        return convertToDto(orderRepository.save(order));
    }


    private OrderResponseDto convertToDto(Order order) {

        OrderResponseDto dto = new OrderResponseDto();

        dto.setOrderId(order.getId());

        dto.setOrderDate(order.getOrderDate());

        dto.setStatus(order.getStatus());

        dto.setTotalAmount(order.getTotalAmount());

        List<OrderItemResponseDto> itemDtos =
                order.getOrderItems()
                        .stream()
                        .map(item -> {

                            OrderItemResponseDto itemDto =
                                    new OrderItemResponseDto();

                            itemDto.setProductId(item.getProduct().getId());

                            itemDto.setProductName(item.getProduct().getName());

                            itemDto.setQuantity(item.getQuantity());

                            itemDto.setPrice(item.getPrice());

                            return itemDto;

                        }).toList();

        dto.setItems(itemDtos);

        return dto;
    }

}