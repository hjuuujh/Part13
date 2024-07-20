package com.zerobase.practice.domain.type;
public enum YesNo {

    Y, N;

    public boolean isYes() {
        return this == Y;
    }

    public boolean isNo() {
        return this == N;
    }
}