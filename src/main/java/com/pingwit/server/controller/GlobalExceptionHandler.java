package com.pingwit.server.controller;

import com.pingwit.server.exception.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        return ResponseEntity
                .badRequest()
                .body(ResponseException.builder()
                        .message(e.getMessage())
                        .build()
                );
    }
}
