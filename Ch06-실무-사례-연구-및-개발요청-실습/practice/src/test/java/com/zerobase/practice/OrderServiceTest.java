package com.zerobase.practice;

import com.zerobase.practice.exception.ZeroBaseException;
import com.zerobase.practice.infra.entity.Book;
import com.zerobase.practice.infra.entity.BookOrder;
import com.zerobase.practice.infra.entity.BookStock;
import com.zerobase.practice.infra.entity.User;
import com.zerobase.practice.infra.repository.BookOrderRepository;
import com.zerobase.practice.infra.repository.BookRepository;
import com.zerobase.practice.infra.repository.BookStockRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static com.zerobase.practice.exception.ExceptionCode.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    BookRepository bookRepository;
    @Mock
    BookStockRepository bookStockRepository;
    @Mock
    BookOrderRepository bookOrderRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    @DisplayName("재고가 정상으로 차감되며 주문이 성공한다.")
    void success__order() {
        // FIXME
        // given
        User user = User.asNew(1L);

        Book book = Book.builder()
                .sale(true)
                .minAge(0)
                .build();
        given(bookRepository.findById(anyLong()))
                .willReturn(Optional.ofNullable(book));

        BookStock bookStock = BookStock.builder()
                .stock(10)
                .build();
        given(bookStockRepository.findByBookId(anyLong()))
                .willReturn(Optional.ofNullable(bookStock));

        BookOrder bookOrder = new BookOrder(1L, user, book);
        given(bookOrderRepository.save(any()))
                .willReturn(bookOrder);

        ArgumentCaptor<BookStock> bookStockCaptor = ArgumentCaptor.forClass(BookStock.class);
        ArgumentCaptor<BookOrder> bookOrderCaptor = ArgumentCaptor.forClass(BookOrder.class);

        // when
        Long order = orderService.order(user, 1l);

        // then
        verify(bookStockRepository, times(1)).save(bookStockCaptor.capture());
        verify(bookOrderRepository, times(1)).save(bookOrderCaptor.capture());
        assertEquals(9, bookStockCaptor.getValue().getStock());
        assertEquals(book, bookOrderCaptor.getValue().getBook());
    }

    @Test
    @DisplayName("Book 존재하지 않으면 익셉션 발생(NOT_FOUND_BOOK)")
    void throwException__when__not_found_book() {
        // FIXME
        User user = User.asNew(1L);

        given(bookRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        //when
        ZeroBaseException exception = assertThrows(ZeroBaseException.class, () -> orderService.order(user, 1l));

        //then
        assertEquals(NOT_FOUND_BOOK, exception.getCode());
        assertEquals("도서를 찾을 수 없습니다", exception.getMessage());

    }

    @Test
    @DisplayName("BookStock 존재하지 않으면 익셉션 발생(NOT_FOUND_BOOK_STOCK)")
    void throwException__when__not_found_bookstock() {
        // FIXME
        User user = User.asNew(1L);

        Book book = Book.builder()
                .sale(true)
                .minAge(0)
                .build();
        given(bookRepository.findById(anyLong()))
                .willReturn(Optional.ofNullable(book));

        given(bookStockRepository.findByBookId(anyLong()))
                .willReturn(Optional.empty());
        //when
        ZeroBaseException exception = assertThrows(ZeroBaseException.class, () -> orderService.order(user, 1l));

        //then
        assertEquals(NOT_FOUND_BOOK_STOCK, exception.getCode());
        assertEquals("재고를 찾을 수 없습니다.", exception.getMessage());


    }

    @Test
    @DisplayName("판매중이지 않은 책을 주문하면 익셉션 발생(FAIL_BOOK_ORDER)")
    void throwException__when__book_sale_off() {
        // FIXME
        // given
        User user = User.asNew(1L);

        Book book = Book.builder()
                .sale(false)
                .minAge(0)
                .build();
        given(bookRepository.findById(anyLong()))
                .willReturn(Optional.ofNullable(book));

        BookStock bookStock = BookStock.builder()
                .stock(10)
                .build();
        given(bookStockRepository.findByBookId(anyLong()))
                .willReturn(Optional.ofNullable(bookStock));

        BookOrder bookOrder = new BookOrder(1L, user, book);
        given(bookOrderRepository.save(any()))
                .willReturn(bookOrder);

        //when
        ZeroBaseException exception = assertThrows(ZeroBaseException.class, () -> orderService.order(user, 1l));

        //then
        assertEquals(BOOK_IS_NOT_SALE, exception.getCode());
        assertEquals("판매중인 도서가 아닙니다", exception.getMessage());


    }

    @Test
    @DisplayName("재고가 부족할때 익셉션 발생(FAIL_BOOK_ORDER)")
    void throwException__when__not_enough_stock() {
        // FIXME
        // given
        User user = User.asNew(1L);

        Book book = Book.builder()
                .sale(true)
                .minAge(0)
                .build();
        given(bookRepository.findById(anyLong()))
                .willReturn(Optional.ofNullable(book));

        BookStock bookStock = BookStock.builder()
                .stock(0)
                .build();
        given(bookStockRepository.findByBookId(anyLong()))
                .willReturn(Optional.ofNullable(bookStock));


        //when
        ZeroBaseException exception = assertThrows(ZeroBaseException.class, () -> orderService.order(user, 1l));

        //then
        assertEquals(FAIL_BOOK_ORDER, exception.getCode());
        assertEquals("도서 재고가 부족합니다.", exception.getMessage());

    }
}