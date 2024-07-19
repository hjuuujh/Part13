package com.zerobase.designpattern.decorator;

public interface Beverage {
    String getName();

    int getPrice();

    default void printPrice(){
        System.out.println(getName()+" 음료가격은 : "+getPrice());
    }
}
