package com.zerobase.designpattern.decorator;

public class Espresso implements Beverage{

    @Override
    public String getName() {
        return "에스프레소";
    }

    @Override
    public int getPrice() {
        return 2000;
    }
}
