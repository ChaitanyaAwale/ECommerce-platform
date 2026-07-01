package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    private String username;
    private String email;
    private String password;

}
