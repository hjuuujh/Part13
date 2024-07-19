package com.zerobase.designpattern.templatemethod.key;

public class AlphabetKey implements KeyboardKey {
    private String keyName;
    public AlphabetKey(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public String getKey() {
        return keyName;
    }
}
