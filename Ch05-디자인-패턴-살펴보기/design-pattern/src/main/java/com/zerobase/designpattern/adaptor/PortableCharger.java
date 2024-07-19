package com.zerobase.designpattern.adaptor;

import com.zerobase.designpattern.adaptor.cable.UsbCable;

public class PortableCharger {
    public void charge(UsbCable usbCable) {
        System.out.println("PortableCharger: "+usbCable.getConnectDeviceName() +" USB 충전중");
    }

}
