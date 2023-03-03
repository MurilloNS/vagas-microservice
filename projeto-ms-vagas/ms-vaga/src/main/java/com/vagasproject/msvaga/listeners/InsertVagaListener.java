package com.vagasproject.msvaga.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vagasproject.msvaga.dto.InsertVagaRequest;
import com.vagasproject.msvaga.entities.Vaga;
import com.vagasproject.msvaga.enums.StatusVaga;
import com.vagasproject.msvaga.repositories.VagaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class InsertVagaListener {
    private final VagaRepository vagaRepository;

    @RabbitListener(queues = "${mq.queues.insert-vaga}")
    public void InsertVagaConsumer(@Payload String payload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InsertVagaRequest insertVagaRequest = mapper.readValue(payload, InsertVagaRequest.class);
            Vaga vaga = Vaga.builder().name(insertVagaRequest.getName()).description(insertVagaRequest.getDescription())
                    .benefit(insertVagaRequest.getBenefit()).statusVaga(StatusVaga.PENDENTE)
                    .initDate(LocalDate.now()).finalizedDate(null).build();

            vagaRepository.insert(vaga);
        } catch (Exception e) {
            log.error("Erro ao receber solicitação de inserção de vaga: {}", e.getMessage());
        }
    }
}
