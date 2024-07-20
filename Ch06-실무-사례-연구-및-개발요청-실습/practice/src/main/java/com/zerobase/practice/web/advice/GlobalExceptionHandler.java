package com.zerobase.practice.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // TODO : 익셉션 핸들러를 작성하세요
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResult> handle5XXException(InternalServerException e) {

        return new ResponseEntity<>(new ErrorResult(e.getCode().toString(), e.getMessage()), HttpStatus.valueOf(500));
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ErrorResult> handle4XXException(ClientException e) {

        return new ResponseEntity<>(new ErrorResult(e.getCode().toString(), e.getMessage()), HttpStatus.valueOf(400));
    }


    @ExceptionHandler(Exception.class)
    public ErrorResult handleException(Exception e) {

        return new ErrorResult(INTERNAL_SERVER_ERROR.toString(), e.getMessage());
    }

}