package com.spring.guru.jms.springjms.listener;

import com.spring.guru.jms.springjms.config.JmsConfig;
import com.spring.guru.jms.springjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders header, Message message ){
        System.out.println("I got message!!!1");

        System.out.println(helloWorldMessage);

    }
}
