package com.zerobase.designpattern.strategy;

public class PercentageCoupon implements Coupon {
    private int ratio;
    public PercentageCoupon(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public int calc(int productAmount) {
        int discountAmount = (int) (productAmount*(double)ratio/100);
        return Math.max(productAmount - discountAmount,0);
    }
}
