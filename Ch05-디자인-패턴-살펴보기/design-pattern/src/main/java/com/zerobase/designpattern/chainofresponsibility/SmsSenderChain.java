package com.zerobase.designpattern.chainofresponsibility;

public class SmsSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("SMS 메세지 전송");
    }
}
