package com.zerobase.zerobasepart13.infra.repository;

import com.zerobase.zerobasepart13.infra.entity.BookOrder;

public interface BookOrderRepository {
    BookOrder save(BookOrder bookOrder);
}
