package com.zerobase.designpattern.templatemethod;

import com.zerobase.designpattern.templatemethod.key.AlphabetKey;
import com.zerobase.designpattern.templatemethod.keyboard.EscKeyMonitoringKeyboard;
import com.zerobase.designpattern.templatemethod.keyboard.Keyboard;
import com.zerobase.designpattern.templatemethod.keyboard.LoggingKeyboard;

public class Main {
    public static void main(String[] args) {
        Keyboard keyboard = new LoggingKeyboard();

        keyboard.press(new AlphabetKey("A"));
        keyboard.press(new AlphabetKey("B"));
        keyboard.press(new AlphabetKey("C"));

        Keyboard keyboard2 = new EscKeyMonitoringKeyboard();
        keyboard2.press(new AlphabetKey("A"));
        keyboard2.press(new AlphabetKey("B"));
        keyboard2.press(new AlphabetKey("esc"));
    }
}
