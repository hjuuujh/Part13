package com.zerobase.zerobasepart13;

import com.zerobase.zerobasepart13.infra.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zerobase.zerobasepart13.exception.ZerobaseException;
import com.zerobase.zerobasepart13.exception.type.ExceptionCode;
import com.zerobase.zerobasepart13.infra.entity.Book;
import com.zerobase.zerobasepart13.infra.entity.BookOrder;
import com.zerobase.zerobasepart13.infra.entity.BookStock;
import com.zerobase.zerobasepart13.infra.repository.BookOrderRepository;
import com.zerobase.zerobasepart13.infra.repository.BookRepository;
import com.zerobase.zerobasepart13.infra.repository.BookStockRepository;
import com.zerobase.zerobasepart13.user.User;
import com.zerobase.zerobasepart13.user.UserInfo;
import com.zerobase.zerobasepart13.user.UserInfoClient;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT) // Unnecessary stubbings detected. 무시하도록
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    BookRepository bookRepository;
    @Mock
    UserInfoClient userInfoClient;
    @Mock
    BookStockRepository bookStockRepository;
    @Mock
    BookOrderRepository bookOrderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        when(bookRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Book(true, 0)));
        when(userInfoClient.findUserInfo(anyLong()))
                .thenReturn(Optional.of(new UserInfo(20, false)));
        when(bookStockRepository.findByBookId(anyLong()))
                .thenReturn(Optional.of(new BookStock(10)));
        when(bookOrderRepository.save(any(BookOrder.class)))
                .thenReturn(new BookOrder(1L, null, null));
    }

    @Test
    void success() {
        Long orderId = orderService.order(User.asNew(1L), 1L);

        assertThat(orderId).isEqualTo(1L);

        // 행위 검증
        // orderService.order()를 호출했을때 아래 함수들이 한번씩 호출 되었는지 확인
        verify(bookRepository).findById(anyLong());
        verify(userInfoClient).findUserInfo(anyLong());
        verify(bookStockRepository).findByBookId(anyLong());
        verify(bookOrderRepository).save(any(BookOrder.class));
    }

    // Exception Test

    @Test
    @DisplayName("Book 존재하지 않으면 익셉션 발생 (NOT_FOUND_BOOK)")
    void throwException_when_not_found_book() {
        //given  //when
        when(bookRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.NOT_FOUND_BOOK);
    }

    @Test
    @DisplayName("UserInfo 존재하지 않으면 익셉션 발생 (USER_INFO_CLIENT_ERROR)")
    void throwException_when_user_info_client_error() {
        //given  //when
        when(userInfoClient.findUserInfo(anyLong()))
                .thenReturn(Optional.empty());
        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.USER_INFO_CLIENT_ERROR);
    }

    @Test
    @DisplayName("재고를 찾을수 없으면 익셉션 발생 (NOT_FOUND_BOOK_STOCK)")
    void throwException_when_not_found_book_stock() {
        //given  //when
        when(bookStockRepository.findByBookId(anyLong()))
                .thenReturn(Optional.empty());
        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.NOT_FOUND_BOOK_STOCK);
    }

    @Test
    @DisplayName("판매하지 않는 책이면 익셉션 발생 (BOOK_IS_NOT_SALE)")
    void throwException_when_book_is_not_sale() {
        //given
        Book book = Book.builder().sale(false).build();
        // when
        when(bookRepository.findById(anyLong()))
                .thenReturn(Optional.of(book));

        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.BOOK_IS_NOT_SALE);
    }

    @Test
    @DisplayName("휴면계정이면 익셉션 발생 (FAIL_BOOK_ORDER)")
    void throwException_when_fail_book_order() {
        //given
        UserInfo userInfo = UserInfo.builder()
                .dormant(true).build();
        // when
        when(userInfoClient.findUserInfo(anyLong()))
                .thenReturn(Optional.of(userInfo));

        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.FAIL_BOOK_ORDER);
    }

    @Test
    @DisplayName("나이제한에 걸리면 익셉션 발생 (FAIL_BOOK_ORDER)")
    void throwException_when_check_enough_age() {
        //given
        Book book = Book.builder().minAge(20).sale(true).build();
        UserInfo userInfo = UserInfo.builder()
                .age(15).dormant(false).build();
        // when
        when(bookRepository.findById(anyLong()))
                .thenReturn(Optional.of(book));
        when(userInfoClient.findUserInfo(anyLong()))
                .thenReturn(Optional.of(userInfo));

        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.FAIL_BOOK_ORDER);
    }

    @Test
    @DisplayName("재고가 부족하면 익셉션 발생 (FAIL_BOOK_ORDER)")
    void throwException_when_check_enough_stock() {
        //given
        BookStock bookStock = BookStock.builder()
                .stock(0).build();

        // when
        when(bookStockRepository.findByBookId(anyLong()))
                .thenReturn(Optional.of(bookStock));

        //then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZerobaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.FAIL_BOOK_ORDER);
    }

    @Test
    @DisplayName("재고가 정상으로 차감된다.")
    void success_when_decrease_stock() {
        //given
        final int stockCount = 10;
        BookStock bookStock = BookStock.builder()
                .stock(stockCount).build();

        //when
        when(bookStockRepository.findByBookId(anyLong()))
                .thenReturn(Optional.of(bookStock));
        orderService.order(User.asNew(1L), 1L);

        //then
        assertThat(bookStock.getStock()).isEqualTo(stockCount - 1);
    }
}