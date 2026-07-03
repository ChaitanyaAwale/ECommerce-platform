package com.Chaitanya.Project1.E_Commerce.platform.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CategoryRequestDto {
@NotBlank(message = "name of category cannot be empty")
    private String name;
}
