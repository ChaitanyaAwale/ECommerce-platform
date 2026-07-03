package com.Chaitanya.Project1.E_Commerce.platform.dto;
//package com.Chaitanya.Project1.E_Commerce.platform.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto {
@NotBlank(message = "street has to be mentioned")
    private String street;
@NotBlank(message="street cannot be empty")
    private String city;
@NotBlank(message="state cannot be empty")
    private String state;
@NotBlank(message = "country cannot be empty")
    private String country;

    private String pincode;

    private Long userId;
}

