package com.zerobase.zerobasepart13.infra.entity;

import com.zerobase.zerobasepart13.exception.ZerobaseException;
import com.zerobase.zerobasepart13.exception.type.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
public class BookStock {
    private int stock;
    public boolean enoughStock() {return stock>0;}
    public void decreaseStock() {
        log.info("Decrease stock");
        if(stock<0) {
            throw new ZerobaseException(ExceptionCode.NOT_ENOUGH_STOCK);
        }
        stock--;
    }
}
