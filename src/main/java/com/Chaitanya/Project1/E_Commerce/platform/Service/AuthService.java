package com.Chaitanya.Project1.E_Commerce.platform.Service;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.User;
import com.Chaitanya.Project1.E_Commerce.platform.Enum.RoleType;
import com.Chaitanya.Project1.E_Commerce.platform.dto.LoginRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.LoginResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.SignupRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.SignupResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignupResponseDto signup(SignupRequestDto dto)
    {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("user with email already exists");
        }
        User user=User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(RoleType.Customer)
                .build();
        User savedUser=userRepository.save(user);
        return SignupResponseDto.builder()
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .username(savedUser.getUsername())
                .message("Signup Succesful")
                .build();


    }

    public LoginResponseDto login(LoginRequestDto dto)
    {
        User user=userRepository.findByEmail(dto.getEmail()).orElseThrow(()-> new RuntimeException("User with this email doesnt exist"));
        if(!passwordEncoder.matches(dto.getPassword(),user.getPassword()))
        {
            throw new RuntimeException("Password Incorrect");
        }
        String token=null;
        return LoginResponseDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .token(token)
                .message("Login Successful")
                .build();
    }

}
