package com.zerobase.practice.domain.repository;

import com.zerobase.practice.domain.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
}