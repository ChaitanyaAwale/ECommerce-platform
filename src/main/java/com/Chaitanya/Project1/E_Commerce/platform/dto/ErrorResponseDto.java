package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ErrorResponseDto {

    private String message;
    private int status;
    private LocalDateTime timestamp;
}
