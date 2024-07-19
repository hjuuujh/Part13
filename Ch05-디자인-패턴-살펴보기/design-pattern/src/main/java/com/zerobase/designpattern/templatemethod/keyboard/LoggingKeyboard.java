package com.zerobase.designpattern.templatemethod.keyboard;

import com.zerobase.designpattern.templatemethod.key.KeyboardKey;

public class LoggingKeyboard extends Keyboard {

    @Override
    protected void keyDown(KeyboardKey keyboardKey) {
        System.out.println("logging key down: " + keyboardKey.getKey());
    }

    @Override
    protected void keyUp(KeyboardKey keyboardKey) {
        System.out.println("logging key up: " + keyboardKey.getKey());
    }


}
