package com.zerobase.practice.web.infra;

import com.zerobase.practice.web.infra.exception.ZeroBaseException;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ZeroBaseException.class)
    public ResponseEntity<ErrorResult> error(ZeroBaseException exception) {
        return new ResponseEntity<>(ErrorResult.of(exception), HttpStatus.valueOf(exception.getHttpStatus()));
    }

    @Value
    @Builder
    static class ErrorResult{
        private String errorCode;
        private String message;

        static ErrorResult of(ZeroBaseException bookStoreException){
            return ErrorResult
                    .builder()
                    .errorCode(bookStoreException.getErrorCode())
                    .message(bookStoreException.getMessage())
                    .build();
        }
    }
}