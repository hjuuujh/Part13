package com.zerobase.designpattern.chainofresponsibility;

public class EmailSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("EMAIL 메세지 전송");
    }
}
