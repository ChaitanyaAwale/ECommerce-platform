package com.Chaitanya.Project1.E_Commerce.platform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

  @NotBlank(message = "Username is required")
  @Size(min=3,max=30,message="Username must be between 3 too 30 letters")
    private String username;
  @NotBlank(message="email is required")
  @Email(message = "enter a valid Email")
    private String email;
  @NotBlank(message = "password cannot be empty")
  @Size(min=8,message = "password must atleast contain 8 chaaracters")
    private String password;

}
