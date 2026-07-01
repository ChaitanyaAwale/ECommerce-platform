package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.*;

@Data
@Getter
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

    private String username;
    private String password;
    private String email;

}
