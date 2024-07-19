package com.zerobase.designpattern.strategy;

public class DiscountCoupon implements Coupon{
    private int discount;

    public DiscountCoupon(int discount) {
        this.discount = discount;
    }

    @Override
    public int calc(int productAmount) {
        return Math.max(productAmount - discount,0);
    }
}
