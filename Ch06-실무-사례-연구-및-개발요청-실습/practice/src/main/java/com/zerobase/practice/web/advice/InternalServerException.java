package com.zerobase.practice.web.advice;

import com.zerobase.practice.web.exception.ExceptionCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalServerException extends RuntimeException {
    private ExceptionCode code;
    private String message;

    public InternalServerException(ExceptionCode exceptionCode) {
        this.code = exceptionCode;
        this.message = exceptionCode.getMessage();
    }
}
