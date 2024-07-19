package com.zerobase.designpattern.templatemethod.keyboard;

import com.zerobase.designpattern.templatemethod.key.KeyboardKey;

public abstract class Keyboard {
    public void press(KeyboardKey keyboardKey) {
        keyDown(keyboardKey);
        System.out.println("입력된 키 : "+keyboardKey.getKey());
        keyUp(keyboardKey);
    }

    protected abstract void keyDown(KeyboardKey keyboardKey);
    protected abstract void keyUp(KeyboardKey keyboardKey);
}
