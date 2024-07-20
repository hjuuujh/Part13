package com.zerobase.practice.domain.repository;

import com.zerobase.practice.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}