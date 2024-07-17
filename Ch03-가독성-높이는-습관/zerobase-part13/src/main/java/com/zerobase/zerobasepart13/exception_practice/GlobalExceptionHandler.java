package com.zerobase.zerobasepart13.exception_practice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionErrorResult> handleRuntimeException(ZerobaseException e) {
        return new ResponseEntity(ExceptionErrorResult.builder()
                .code(e.getCode().name())
                .message(e.getMessage())
                .build(), e.getCode().getHttpStatus());
    }
}
