package com.spring.guru.jms.springjms.sender;

import com.spring.guru.jms.springjms.config.JmsConfig;
import com.spring.guru.jms.springjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {
    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I'm sending message...");

        HelloWorldMessage message = new HelloWorldMessage()
                .builder()
                .id(UUID.randomUUID())
                .message("hello-world")
                .build();
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,message);
        System.out.println("Message sent!");
    }
}
