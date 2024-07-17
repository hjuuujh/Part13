package com.zerobase.zerobasepart13.exception_practice;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ExceptionErrorResult {
    private String code;
    private String message;
}
