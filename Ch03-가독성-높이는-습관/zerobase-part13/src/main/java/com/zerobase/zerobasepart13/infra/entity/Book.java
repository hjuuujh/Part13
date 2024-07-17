package com.zerobase.zerobasepart13.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
public class Book {
    private boolean sale;
    private int minAge;

    public boolean enoughAge(int age) {
        return minAge <= age;
    }
}
