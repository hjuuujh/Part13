package com.zerobase.practice.infra.repository;


import com.zerobase.practice.infra.entity.BookOrder;

public interface BookOrderRepository {
    BookOrder save(BookOrder bookOrder);
}