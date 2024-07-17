package com.zerobase.zerobasepart13.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {
    NOT_FOUND_BOOK(HttpStatus.INTERNAL_SERVER_ERROR, "도서를 찾을 수 없습니다."),
    NOT_FOUND_BOOK_STOCK(HttpStatus.INTERNAL_SERVER_ERROR, "재고를 찾을수 없습니다."),
    USER_INFO_CLIENT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "유저 정보 조회에 실패하였습니다."),
    BOOK_IS_NOT_SALE(HttpStatus.INTERNAL_SERVER_ERROR, "판매중인 도서가 아닙니다."),

    NOT_ENOUGH_STOCK(HttpStatus.INTERNAL_SERVER_ERROR, "재고가 부족합니다."),

    FAIL_BOOK_ORDER(HttpStatus.INTERNAL_SERVER_ERROR, "도서주문이 실패하였습니다.");


    private final HttpStatus httpStatus;
    private final String message;
}
