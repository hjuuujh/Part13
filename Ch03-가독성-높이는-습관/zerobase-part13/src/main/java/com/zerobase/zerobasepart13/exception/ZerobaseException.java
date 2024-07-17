package com.zerobase.zerobasepart13.exception;

import com.zerobase.zerobasepart13.exception.type.ExceptionCode;
import lombok.Getter;

@Getter
public class ZerobaseException extends RuntimeException {
    private final ExceptionCode code;

    public ZerobaseException(ExceptionCode code) {
        this.code = code;
    }

    public ZerobaseException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }

    public ZerobaseException(String message, Throwable cause, ExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ZerobaseException(Throwable cause, ExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public ZerobaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionCode code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public ZerobaseException(ExceptionCode exceptionCode, String s) {
        super(s);
        this.code = exceptionCode;

    }

    public ZerobaseException(ExceptionCode exceptionCode, String s, Throwable cause) {
        super(s);
        this.code = exceptionCode;

    }
}
