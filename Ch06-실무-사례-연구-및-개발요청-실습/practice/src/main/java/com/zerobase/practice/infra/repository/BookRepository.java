package com.zerobase.practice.infra.repository;

import com.zerobase.practice.infra.entity.Book;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(long bookId);
}