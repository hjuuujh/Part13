package com.zerobase.zerobasepart13.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
public class UserInfo {
    private final int age;
    private boolean dormant;
}
