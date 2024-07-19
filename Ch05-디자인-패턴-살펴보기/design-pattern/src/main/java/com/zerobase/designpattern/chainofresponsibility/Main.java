package com.zerobase.designpattern.chainofresponsibility;

import static java.util.Objects.isNull;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        MessageSenderChain smsSenderChain = new SmsSenderChain();
        MessageSenderChain pushSenderChain = new PushSenderChain();
        MessageSenderChain emailSenderChain = new EmailSenderChain();
//        smsSenderChain.setNext(pushSenderChain);
//        pushSenderChain.setNext(emailSenderChain);
        smsSenderChain.next(pushSenderChain)
                        .next(emailSenderChain);
        // ==
        MessageSenderChain smsSenderChain2 = new SmsSenderChain();
        smsSenderChain2.next(new PushSenderChain())
                        .next(new EmailSenderChain());

        smsSenderChain.send(user, new MessageDetail());
    }
}
