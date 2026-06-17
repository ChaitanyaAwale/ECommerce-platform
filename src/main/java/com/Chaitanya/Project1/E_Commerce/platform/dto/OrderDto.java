package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long UserId;
    private BigDecimal totalAmount;
    private String Status;

}
