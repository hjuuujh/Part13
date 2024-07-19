package com.zerobase.designpattern.adaptor.adaptor;

import com.zerobase.designpattern.adaptor.cable.CtypeCable;
import com.zerobase.designpattern.adaptor.cable.LightningCable;

public class LightningCableToCtypeAdaptor implements CtypeCable {
    private LightningCable lightningCable;
    public LightningCableToCtypeAdaptor(LightningCable lightningCable) {
        this.lightningCable = lightningCable;
    }

    @Override
    public String getCytpeConnectDeviceName() {
        return lightningCable.getLightningConnectDeviceName();
    }
}
