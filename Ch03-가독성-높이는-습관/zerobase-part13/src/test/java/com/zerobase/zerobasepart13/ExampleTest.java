package com.zerobase.zerobasepart13;

import com.zerobase.zerobasepart13.infra.entity.BookStock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class ExampleTest {
    // 상태 테스트
    @Test
    @DisplayName("BookStock 재고 확인")
    void stock_check() {
        BookStock bookStock = BookStock.builder()
                .stock(10).build();
        assertThat(bookStock.getStock()).isEqualTo(10);
    }

    @Test
    @DisplayName("BookStock 재고 없으면 false")
    void enough_stock_test() {
        BookStock bookStock = BookStock.builder()
                .stock(0).build();
        assertThat(bookStock.enoughStock()).isFalse();
    }


    @Test
    @DisplayName("BookStock 재고 감소")
    void stock_decrease_test() {
        BookStock bookStock = BookStock.builder()
                .stock(10).build();
        bookStock.decreaseStock();
        assertThat(bookStock.getStock()).isEqualTo(9);

    }

    // 행위 테스트
    @Test
    void test(){
        BookStock mock = Mockito.mock(BookStock.class);

        mock.decreaseStock();

        verify(mock, atLeastOnce()).decreaseStock(); // 한번 호출되었는지 확인
    }
}
