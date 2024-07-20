package com.zerobase.practice.domain.entity;

import com.zerobase.practice.web.infra.exception.ExceptionCode;
import com.zerobase.practice.web.infra.exception.ZeroBaseException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Table(name = "book_stock")
@NoArgsConstructor
public class BookStock extends BaseEntity {

    @Id
    @Column(name = "book_stock_id")
    @GeneratedValue
    private Long id;

    @Column
    private Long bookId;

    @Column
    private int stock;

    @Builder
    public BookStock(Long bookId, int stock) {
        this.bookId = bookId;
        this.stock = stock;
    }

    public boolean enoughStock() {
        return stock > 0;
    }

    public void decreaseStock() {
        log.info("decreaseStock!!");
        if(stock <= 0)
            throw new ZeroBaseException(ExceptionCode.NOT_ENOUGH_STOCK);

        stock--;
    }
}