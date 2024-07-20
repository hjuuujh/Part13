package com.zerobase.practice.web.controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookOrderResponse {
    private Long orderId;
}