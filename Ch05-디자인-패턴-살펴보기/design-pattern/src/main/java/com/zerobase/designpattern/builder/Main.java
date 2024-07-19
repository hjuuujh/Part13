package com.zerobase.designpattern.builder;

import com.zerobase.designpattern.factorymethod.Car;
import com.zerobase.designpattern.factorymethod.CarFactory;
import com.zerobase.designpattern.factorymethod.EngineType;
import com.zerobase.designpattern.sigleton.Singleton;

public class Main {
    public static void main(String[] args) {

//        SimpleUser simpleUser = new SimpleUser();
//        SimpleUser simpleUser = SimpleUser.builder()
//                .id(1L)
//                .name("제로베이스")
//                .age(25)
//                .address("서울시")
//                .phoneNumber("010-1234-5678")
//                .build();

        SimpleUser simpleUser = SimpleUser.builder()
                .userInfo(new UserInfo())
                .userAddress(new UserAddress())
                .build();

    }
}
