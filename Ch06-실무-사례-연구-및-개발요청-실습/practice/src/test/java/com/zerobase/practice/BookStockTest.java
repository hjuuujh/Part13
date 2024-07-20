package com.zerobase.practice;

import com.zerobase.practice.exception.ZeroBaseException;
import com.zerobase.practice.infra.entity.BookStock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.zerobase.practice.exception.ExceptionCode.NOT_ENOUGH_STOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class BookStockTest {

    @Test
    @DisplayName("BookStock 재고가 정상적으로 차감된다")
    void success__decreaseStock() {
        // FIXME
        // given
        BookStock bookStock = BookStock.builder()
                .stock(10)
                .build();
        // when
        bookStock.decreaseStock();

        // then
        assertEquals(9, bookStock.getStock());
    }

    @Test
    @DisplayName("BookStock 재고가 0일때, 차감을 시도하면 익셉션 발생(NOT_ENOUGH_STOCK)")
    void throwException__when__not_enough_stock() {
        // FIXME
        // given
        BookStock bookStock = BookStock.builder()
                .stock(0)
                .build();
        //when
        ZeroBaseException exception = assertThrows(ZeroBaseException.class, () -> bookStock.decreaseStock());

        //then
        assertEquals(NOT_ENOUGH_STOCK, exception.getCode());
        assertEquals("재고가 부족합니다", exception.getMessage());

    }
}