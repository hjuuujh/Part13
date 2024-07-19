package com.zerobase.designpattern.chainofresponsibility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainConfig {

    @Bean
    public MessageSenderChain chain(){
        MessageSenderChain chain = new SmsSenderChain();
        chain.next(new PushSenderChain())
                .next(new EmailSenderChain());
        return chain;
    }
}
