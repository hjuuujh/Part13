package com.zerobase.zerobasepart13.infra.repository;

import com.zerobase.zerobasepart13.infra.entity.BookStock;

import java.util.Optional;

public interface BookStockRepository {
    Optional<BookStock> findByBookId(long bookId);
    void save(BookStock bookStock);
}
