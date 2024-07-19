package com.zerobase.designpattern.decorator;

public class Water implements Beverage {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
