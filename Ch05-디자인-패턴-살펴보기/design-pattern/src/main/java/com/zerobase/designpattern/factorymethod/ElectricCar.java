package com.zerobase.designpattern.factorymethod;

public class ElectricCar implements Car {
    @Override
    public void whatIsCar() {
        System.out.println(getClass().getSimpleName());
    }
}
