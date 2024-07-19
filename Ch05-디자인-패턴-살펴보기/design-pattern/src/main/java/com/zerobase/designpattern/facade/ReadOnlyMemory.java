package com.zerobase.designpattern.facade;

public class ReadOnlyMemory {
    public Bios getBios() {
        return new Bios();
    }
}
