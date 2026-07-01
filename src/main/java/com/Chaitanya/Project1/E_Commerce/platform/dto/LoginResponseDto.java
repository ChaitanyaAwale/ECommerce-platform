package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
//@Data
public class LoginResponseDto {
private Long userId;
   private String token;
    private String username;
private String message;

}
