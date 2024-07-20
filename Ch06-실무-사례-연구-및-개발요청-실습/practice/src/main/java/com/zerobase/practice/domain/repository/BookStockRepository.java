package com.zerobase.practice.domain.repository;

import com.zerobase.practice.domain.entity.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookStockRepository extends JpaRepository<BookStock, Long> {
    Optional<BookStock> findByBookId(long bookId);
    List<BookStock> findAllByBookId(long bookId);
}