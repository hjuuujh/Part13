package com.zerobase.practice.web.infra.exception;


public class ZeroBaseException extends RuntimeException {

    private ExceptionCode code;
    private int httpStatus;
    private String message;

    public ZeroBaseException(ExceptionCode code) {
        this.code = code;
        this.httpStatus = code.getStatus();
        this.message = code.getMessage();
    }

    public ZeroBaseException(ExceptionCode code, int httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = code.getMessage();
    }

    public ZeroBaseException(ExceptionCode code, String errorMessage) {
        this.code = code;
        this.httpStatus = code.getStatus();
        this.message = errorMessage;
    }

    public ZeroBaseException(ExceptionCode code, int httpStatus, String errorMessage) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = errorMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return code.name();
    }
}