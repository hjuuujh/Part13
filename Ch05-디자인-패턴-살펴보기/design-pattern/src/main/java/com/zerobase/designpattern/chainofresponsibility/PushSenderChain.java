package com.zerobase.designpattern.chainofresponsibility;

public class PushSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("PUSH 메세지 전송");
    }
}
