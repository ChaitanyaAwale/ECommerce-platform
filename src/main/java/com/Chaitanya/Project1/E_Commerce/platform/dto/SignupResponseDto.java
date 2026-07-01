package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.*;

@Data
@Getter
@Builder
@Setter
//@RequiredArgsConstructor
public class SignupResponseDto {

    private String username;
    private String token;
    private Long userId;
    private String email;
    private String message;

}
