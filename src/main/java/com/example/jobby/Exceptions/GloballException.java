package com.example.jobby.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.jobby.DTO.ApiResponse;

@RestControllerAdvice
public class GloballException extends RuntimeException{


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> NotFoundExceptions(NotFoundException ex){
        ApiResponse<Object> response = new ApiResponse<>();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredential.class)
    public ResponseEntity<ApiResponse<Object>> InvalidAuth(InvalidCredential ex){
        ApiResponse<Object> response = new ApiResponse<>();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
