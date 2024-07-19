package com.zerobase.designpattern.adaptor;

import com.zerobase.designpattern.adaptor.cable.LightningCable;

public class iPhone implements LightningCable {
    @Override
    public String getLightningConnectDeviceName() {
        return getClass().getSimpleName();
    }
}
