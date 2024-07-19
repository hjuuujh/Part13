package com.zerobase.designpattern.strategy;

public class CouponService {
    private CouponRepository couponRepository = new MockCouponRepository();

    public Coupon getCoupon(long couponId) {
        return couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);
    }
}
