package com.zerobase.designpattern.chainofresponsibility;

import static java.util.Objects.nonNull;

public abstract class MessageSenderChain {
    private MessageSenderChain next;

    public void setNext(MessageSenderChain next) {
        this.next = next;
    }

    public MessageSenderChain next(MessageSenderChain next) {
        this.next = next;
        return next;
    }

    public void send(User user, MessageDetail messageDetail) {
        // TODO
        execute(user, messageDetail);

        // next
        if (nonNull(next))
            next.send(user, messageDetail);
    }

    protected abstract void execute(User user, MessageDetail messageDetail);

}
