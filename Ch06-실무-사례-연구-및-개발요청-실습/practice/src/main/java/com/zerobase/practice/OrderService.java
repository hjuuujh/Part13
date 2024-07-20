package com.zerobase.practice;


import com.zerobase.practice.exception.ExceptionCode;
import com.zerobase.practice.exception.ZeroBaseException;
import com.zerobase.practice.infra.entity.Book;
import com.zerobase.practice.infra.entity.BookOrder;
import com.zerobase.practice.infra.entity.BookStock;
import com.zerobase.practice.infra.entity.User;
import com.zerobase.practice.infra.repository.BookOrderRepository;
import com.zerobase.practice.infra.repository.BookRepository;
import com.zerobase.practice.infra.repository.BookStockRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final BookRepository bookRepository;
    private final BookStockRepository bookStockRepository;
    private final BookOrderRepository bookOrderRepository;

    public Long order(User user, long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ZeroBaseException(ExceptionCode.NOT_FOUND_BOOK));
        BookStock bookStock = bookStockRepository.findByBookId(bookId)
                .orElseThrow(() -> new ZeroBaseException(ExceptionCode.NOT_FOUND_BOOK_STOCK));

        checkOnSale(book);
        checkEnoughStock(bookStock);

        bookStock.decreaseStock();
        bookStockRepository.save(bookStock);
        BookOrder bookOrder = bookOrderRepository.save(createBookOrder(user, book));
        return bookOrder.getId();
    }

    private BookOrder createBookOrder(User user, Book book) {
        return BookOrder
                .builder()
                .user(user)
                .book(book)
                .build();
    }

    private void checkEnoughStock(BookStock bookStock) {
        if (!bookStock.enoughStock())
            throw new ZeroBaseException(ExceptionCode.FAIL_BOOK_ORDER, "도서 재고가 부족합니다.");
    }

    private void checkOnSale(Book book) {
        if (!book.onSale())
            throw new ZeroBaseException(ExceptionCode.BOOK_IS_NOT_SALE);
    }
}