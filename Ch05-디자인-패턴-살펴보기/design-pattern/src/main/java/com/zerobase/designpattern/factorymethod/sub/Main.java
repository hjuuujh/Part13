package com.zerobase.designpattern.factorymethod.sub;

import com.zerobase.designpattern.factorymethod.Car;

public class Main {
    public static void main(String[] args) {
        AbstractCarFactory electricCarFactory = new ElectricCarFactory();
        Car electricCar = electricCarFactory.createCar();
        electricCar.whatIsCar();

        AbstractCarFactory dieselCarFactory = new DieselCarFactory();
        Car dieselCar = dieselCarFactory.createCar();
        dieselCar.whatIsCar();

        AbstractCarFactory hydrogenCarFactory = new HydrogenCarFactory();
        Car hydrogenCar = hydrogenCarFactory.createCar();
        hydrogenCar.whatIsCar();
    }
}
