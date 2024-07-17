package com.zerobase.zerobasepart13;

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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
    private final BookRepository bookRepository;
    private final UserInfoClient userInfoClient;
    private final BookStockRepository bookStockRepository;
    private final BookOrderRepository bookOrderRepository;

    public Long order(User user, long bookId){
        Book book = findBook(bookId);
        UserInfo info = findUserInfo(user);
        BookStock bookStock = findBookStock(bookId);

        checkOnSale(book);
        checkDormant(info);
        checkEnoughAge(book, info);
        checkEnoughStock(bookStock);

        bookStock.decreaseStock();
        bookStockRepository.save(bookStock);
        BookOrder bookOrder = bookOrderRepository.save(createBookOrder(user,book));
        return bookOrder.getId();
    }

    private BookOrder createBookOrder(User user, Book book) {
        return BookOrder.builder()
                .user(user)
                .book(book)
                .build();
    }

    private void checkEnoughStock(BookStock bookStock) {
        if(!bookStock.enoughStock())
            throw new ZerobaseException(ExceptionCode.FAIL_BOOK_ORDER, "도서 재고가 부족합니다.");
    }

    private void checkEnoughAge(Book book, UserInfo info) {
        if(!book.enoughAge(info.getAge()))
            throw new ZerobaseException(ExceptionCode.FAIL_BOOK_ORDER, "나이제한이 걸려 주문할 수 없습니다.");
    }

    private void checkDormant(UserInfo info) {
        if(info.isDormant())
            throw new ZerobaseException(ExceptionCode.FAIL_BOOK_ORDER, "휴면고객은 주문할 수 없습니다.");
    }

    private void checkOnSale(Book book) {
        if(!book.isSale())
            throw new ZerobaseException(ExceptionCode.BOOK_IS_NOT_SALE);
    }

    private BookStock findBookStock(long bookId) {
        return bookStockRepository.findByBookId(bookId)
                .orElseThrow(()->new ZerobaseException(ExceptionCode.NOT_FOUND_BOOK_STOCK));
    }

    private UserInfo findUserInfo(User user) {
        return userInfoClient.findUserInfo(user.getId())
                .orElseThrow(()->new ZerobaseException(ExceptionCode.USER_INFO_CLIENT_ERROR));
    }

    private Book findBook(long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(()->new ZerobaseException(ExceptionCode.NOT_FOUND_BOOK));
    }
}
