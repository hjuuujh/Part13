package com.zerobase.practice.infra.repository;


import com.zerobase.practice.infra.entity.BookStock;

import java.util.Optional;

public interface BookStockRepository {
    Optional<BookStock> findByBookId(long bookId);

    void save(BookStock bookStock);
}