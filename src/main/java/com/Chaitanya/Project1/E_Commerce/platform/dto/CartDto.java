package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Long userId;
    private Long cartId;
    private List<CartItemDto> items;
    private Double totalPrices;
}
