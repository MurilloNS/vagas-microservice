package com.vagasproject.msadministrator.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vagasproject.msadministrator.dto.InsertVagaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertVagaPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queueInsertVaga;

    public InsertVagaRequest insertVaga(InsertVagaRequest insertVagaRequest) throws JsonProcessingException {
        String json = convertIntoJson(insertVagaRequest);
        rabbitTemplate.convertAndSend(queueInsertVaga.getName(), json);
        return insertVagaRequest;
    }

    private String convertIntoJson(InsertVagaRequest insertVagaRequest) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(insertVagaRequest);
    }
}
