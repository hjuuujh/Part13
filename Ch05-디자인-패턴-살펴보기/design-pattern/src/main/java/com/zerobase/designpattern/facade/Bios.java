package com.zerobase.designpattern.facade;

public class Bios {
    public boolean post() {
        return true;
    }

    public BootLoader getBootLoader(ReadOnlyMemory rom) {
        return new BootLoader();
    }

    public OperationSystem findOperationSystem(HardDiskDrive hdd) {
        return new OperationSystem();
    }
}
