package com.zerobase.designpattern.templatemethod.keyboard;

import com.zerobase.designpattern.templatemethod.key.KeyboardKey;

public class EscKeyMonitoringKeyboard extends Keyboard {
    @Override
    protected void keyDown(KeyboardKey keyboardKey) {
        if(isEscKey(keyboardKey)){
            System.out.println("ESC logging key down: " + keyboardKey.getKey());
        }
    }

    @Override
    protected void keyUp(KeyboardKey keyboardKey) {
        if(isEscKey(keyboardKey)){
            System.out.println("ESC logging key up: " + keyboardKey.getKey());
        }
    }

    private boolean isEscKey(KeyboardKey keyboardKey) {
        return "ESC".equalsIgnoreCase(keyboardKey.getKey());
    }
}
