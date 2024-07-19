package com.zerobase.designpattern.builder;

import lombok.Getter;

@Getter
public class UserAddress {
    private String city;
    private String citySubName;
    private String cityName;

    public String mergeAddress() {
        return city + citySubName + cityName;
    }
}
