package com.zerobase.zerobasepart13.infra.entity;

import com.zerobase.zerobasepart13.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
public class BookOrder {
    private Long id;
    private User user;
    private Book book;
}
