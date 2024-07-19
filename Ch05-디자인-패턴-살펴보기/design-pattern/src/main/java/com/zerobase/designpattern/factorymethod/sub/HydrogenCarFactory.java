
package com.zerobase.designpattern.factorymethod.sub;

import com.zerobase.designpattern.factorymethod.Car;
import com.zerobase.designpattern.factorymethod.ElectricCar;
import com.zerobase.designpattern.factorymethod.HydrogenCar;

public class HydrogenCarFactory extends AbstractCarFactory {
    @Override
    public Car createCar() {
        return new HydrogenCar();
    }
}
