package com.zerobase.practice.web.controller;

import com.zerobase.practice.domain.OrderService;
import com.zerobase.practice.domain.entity.User;
import com.zerobase.practice.web.controller.model.BookOrderRequest;
import com.zerobase.practice.web.controller.model.BookOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/book/order")
    public BookOrderResponse order(User user, @RequestBody BookOrderRequest params) {
        Long orderId = orderService.order(user, params.getBookId());

        return BookOrderResponse
                .builder()
                .orderId(orderId)
                .build();
    }
}