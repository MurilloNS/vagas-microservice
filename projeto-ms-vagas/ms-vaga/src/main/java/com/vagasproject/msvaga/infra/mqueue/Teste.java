package com.vagasproject.msvaga.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Teste {
    @RabbitListener(queues = "${mq.queues.teste}")
    public void teste(@Payload String payload) {
        System.out.println(payload);
    }
}
