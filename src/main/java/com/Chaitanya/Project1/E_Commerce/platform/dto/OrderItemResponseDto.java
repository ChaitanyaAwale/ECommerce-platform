package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class OrderItemResponseDto {

    private Long productId;

    private String productName;

    private Integer quantity;

    private BigDecimal price;
}