package com.zerobase.designpattern.strategy;

import java.util.Optional;

public interface CouponRepository {
    Optional<Coupon> findById(Long id);
}
