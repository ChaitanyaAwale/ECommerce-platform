package com.Chaitanya.Project1.E_Commerce.platform.dto;

import com.Chaitanya.Project1.E_Commerce.platform.Enum.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {

    private Long orderId;

    private LocalDateTime orderDate;

    private OrderStatus status;

    private BigDecimal totalAmount;

    private List<OrderItemResponseDto> items;
}