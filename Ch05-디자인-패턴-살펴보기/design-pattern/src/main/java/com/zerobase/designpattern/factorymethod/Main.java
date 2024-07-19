package com.zerobase.designpattern.factorymethod;

import com.zerobase.designpattern.sigleton.Singleton;

public class Main {
    public static void main(String[] args) {

        // bean
        CarFactory factory = new CarFactory();
        // service
        Car electricCar = factory.createCar(EngineType.ELECTRIC);
        electricCar.whatIsCar();
        Car dieselCar = factory.createCar(EngineType.DIESEL);
        dieselCar.whatIsCar();
        Car hydrogenCar = factory.createCar(EngineType.HYDROGEN);
        hydrogenCar.whatIsCar();

    }
}
