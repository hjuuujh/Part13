package com.zerobase.designpattern.facade;

public class Mainboard {
    public ReadOnlyMemory supply(Power power) {
        return new ReadOnlyMemory();
    }
}
