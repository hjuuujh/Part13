package com.zerobase.designpattern.adaptor.adaptor;

import com.zerobase.designpattern.adaptor.MacBook;
import com.zerobase.designpattern.adaptor.cable.CtypeCable;
import com.zerobase.designpattern.adaptor.cable.UsbCable;

public class CtypeToUsbAdaptor implements UsbCable {
    private CtypeCable ctypeCable;
    public CtypeToUsbAdaptor(CtypeCable ctypeCable) {
        this.ctypeCable = ctypeCable;
    }

    @Override
    public String getConnectDeviceName() {
        return ctypeCable.getCytpeConnectDeviceName();
    }
}
