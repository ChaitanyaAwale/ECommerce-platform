package com.Chaitanya.Project1.E_Commerce.platform.exceptions;


import com.Chaitanya.Project1.E_Commerce.platform.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//import static jdk.internal.joptsimple.internal.Messages.message;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        ErrorResponseDto error= ErrorResponseDto.builder()
        .message(ex.getMessage())
            .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                    .build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponseDto> handleDuplicateResourceException(DuplicateResourceException ex)
    {
        ErrorResponseDto error=ErrorResponseDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex)
    {
        ErrorResponseDto error=ErrorResponseDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnautohorizeException.class)
    ResponseEntity<ErrorResponseDto> handleUnauthorizeException(UnautohorizeException ex)
    {
        ErrorResponseDto error=ErrorResponseDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.UNAUTHORIZED.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponseDto> Exception(Exception ex)
    {
        ErrorResponseDto error=ErrorResponseDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
