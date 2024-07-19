package com.zerobase.designpattern.adaptor;

import com.zerobase.designpattern.adaptor.cable.UsbCable;

public class PortablePan implements UsbCable {
    @Override
    public String getConnectDeviceName() {
        return getClass().getSimpleName();
    }
}
