package com.zerobase.designpattern.facade;

public class Main {
    public static void main(String[] args) {
//        Power power = new Power();
//
//        if (!power.checkElectric()) {
//            System.out.println("전력이 비정상");
//            return;
//        }
//
//        Mainboard mainboard = new Mainboard();
//        ReadOnlyMemory rom = mainboard.supply(power);
//        Bios bios = rom.getBios();
//
//        if (!bios.post()) {
//            System.out.println("장치 불량");
//            return;
//        }
//
//        BootLoader bootLoader = bios.getBootLoader(rom);
//        HardDiskDrive hdd = new HardDiskDrive();
//
//        OperationSystem os = bios.findOperationSystem(hdd);
//        RandomAccessMemory ram = new RandomAccessMemory();
//        os.bootStrap(ram);

        // 현실에서는 위의 과정들을 자세히 알필요없이
        // "컴퓨터를 킨다" 로 사용
        Computer computer = new Computer();
        computer.turnOn();
    }
}
