package com.zerobase.designpattern.strategy;

public class Main {
    private static CouponService couponService = new CouponService();
    public static void main(String[] args) {
//        Coupon discountCoupon = new DiscountCoupon(2000);
//        System.out.println(discountCoupon.calc(3000));
//
//        Coupon percentageCoupon = new PercentageCoupon(10);
//        System.out.println(percentageCoupon.calc(3000));


        int productPrice = 1000;
        Product ipadPro;
        ipadPro = new Product("아이패드 프로", 1500000);
        Coupon percentageCoupon = couponService.getCoupon(10L);
        int discountAmount = ipadPro.discount(percentageCoupon);
        System.out.println("실제가격 : "+discountAmount);
//        System.out.println(percentageCoupon.calc(productPrice));
//
//        Coupon discountCoupon = couponService.getCoupon(500L);
//        System.out.println(discountCoupon.calc(productPrice));
    }
}
