package com.zerobase.zerobasepart13.infra.repository;

import com.zerobase.zerobasepart13.infra.entity.Book;

import java.util.Optional;

public interface BookRepository{
    Optional<Book> findById(long id);
}
