package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dtos.ErrorDto;
import com.exceptions.ProductNotFoundException;
import com.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity<ErrorDto> handleProductNotFoundException(
                        ProductNotFoundException ex) {

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new ErrorDto(
                                                404,
                                                ex.getMessage()));
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorDto> handleResourceNotFoundException(
                        ResourceNotFoundException ex) {

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new ErrorDto(
                                                404,
                                                ex.getMessage()));
        }
}