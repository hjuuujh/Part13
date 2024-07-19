package com.zerobase.designpattern.adaptor;

import com.zerobase.designpattern.adaptor.cable.CtypeCable;

public class MacBook implements CtypeCable {
    @Override
    public String getCytpeConnectDeviceName() {
        return getClass().getSimpleName();
    }
}
