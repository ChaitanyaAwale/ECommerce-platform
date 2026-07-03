package com.Chaitanya.Project1.E_Commerce.platform.dto;
//package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ValidationErrorResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String,String> errors;
}
