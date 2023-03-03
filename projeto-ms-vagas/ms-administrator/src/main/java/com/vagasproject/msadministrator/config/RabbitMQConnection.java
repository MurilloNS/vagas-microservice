package com.vagasproject.msadministrator.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConnection {
    @Value("${mq.queues.insert-vaga}")
    private String insertVagasFila;

    @Bean
    public Queue queues() {
        return new Queue(insertVagasFila, true);
    }
}
