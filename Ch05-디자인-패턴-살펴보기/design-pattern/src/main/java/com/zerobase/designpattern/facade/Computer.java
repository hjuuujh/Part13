package com.zerobase.designpattern.facade;

public class Computer {
    private Power power = new Power();
    private Mainboard mainboard = new Mainboard();
    private HardDiskDrive hdd = new HardDiskDrive();
    private RandomAccessMemory ram = new RandomAccessMemory();


    public void turnOn() {

        if (!power.checkElectric()) {
            System.out.println("전력이 비정상");
            return;
        }

        ReadOnlyMemory rom = mainboard.supply(power);
        Bios bios = rom.getBios();

        if (!bios.post()) {
            System.out.println("장치 불량");
            return;
        }

        BootLoader bootLoader = bios.getBootLoader(rom);

        OperationSystem os = bios.findOperationSystem(hdd);
        os.bootStrap(ram);
    }
}
