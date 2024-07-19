package com.zerobase.designpattern.sigleton;

import com.zerobase.designpattern.factorymethod.Car;
import com.zerobase.designpattern.factorymethod.CarFactory;
import com.zerobase.designpattern.factorymethod.EngineType;

public class Main {
    public static void main(String[] args) {

        // 언제든지 전역적으로 매번 같은 인스턴스 가져올 수 있음
        Singleton singleton = Singleton.getInstance();

    }
}
