package com.zerobase.designpattern.decorator;

public class Americano implements Beverage {
    private Beverage espresso;
    private Beverage water;
    public Americano(Beverage espresso, Beverage water) {
        this.espresso = espresso;
        this.water = water;
    }

    @Override
    public String getName() {
        return "아메리카노";
    }

    @Override
    public int getPrice() {
        return espresso.getPrice() + water.getPrice();
    }
}
