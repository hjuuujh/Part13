package com.zerobase.zerobasepart13.exception_practice;

import com.zerobase.zerobasepart13.exception_practice.type.ExceptionCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }

    @GetMapping("/exception")
    public void error(){
        throw new ZerobaseException(ExceptionCode.INTERNAL_ERROR, "바뀐에러");
    }
}
