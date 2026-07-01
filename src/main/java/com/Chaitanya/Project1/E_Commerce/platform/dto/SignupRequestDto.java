package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class SignupRequestDto {

    private String username;
    private String Password;
    private String email;

}
