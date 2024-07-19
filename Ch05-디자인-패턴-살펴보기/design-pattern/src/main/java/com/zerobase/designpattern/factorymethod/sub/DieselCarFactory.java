
package com.zerobase.designpattern.factorymethod.sub;

import com.zerobase.designpattern.factorymethod.Car;
import com.zerobase.designpattern.factorymethod.DieselCar;
import com.zerobase.designpattern.factorymethod.ElectricCar;

public class DieselCarFactory extends AbstractCarFactory {
    @Override
    public Car createCar() {
        return new DieselCar();
    }
}
