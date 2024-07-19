package com.zerobase.designpattern.factorymethod;

public class CarFactory {
    public Car createCar(EngineType engineType) {

        if(engineType.isElectric())
            return new ElectricCar();
        if(engineType.isDiesel())
            return new DieselCar();
        if(engineType.isHydrogen())
            return new HydrogenCar();
        throw new RuntimeException("Unsupported Engine Type");
    }
}
