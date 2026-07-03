package com.Chaitanya.Project1.E_Commerce.platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotBlank(message="product name cannot be blank")
    private String name;
@NotBlank(message = "Description is required")
    private String description;
@Positive(message = "price cannot be negative or zero")
    private BigDecimal price;

@PositiveOrZero(message = "quantity cannot be negative")
    private Integer stockQuantity;

    private String imageUrl;

    private Long categoryId;
}