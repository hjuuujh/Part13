package com.zerobase.designpattern.adaptor;

import com.zerobase.designpattern.adaptor.adaptor.CtypeToUsbAdaptor;
import com.zerobase.designpattern.adaptor.adaptor.LightningCableToCtypeAdaptor;

public class Main {
    public static void main(String[] args) {
        MacBook macBook = new MacBook();
        iPhone iphone = new iPhone();
        PortablePan pan = new PortablePan();

        PortableCharger portableCharger = new PortableCharger();
        portableCharger.charge(pan);

        // mackBook은 ctype이기때문에 변환 필요 -> Adaptor 이용
        portableCharger.charge(new CtypeToUsbAdaptor(macBook));

        // 8pin -> usb 불가능
        // 8pin -> C type -> usb
        portableCharger.charge(new CtypeToUsbAdaptor(new LightningCableToCtypeAdaptor(iphone)));

    }
}
