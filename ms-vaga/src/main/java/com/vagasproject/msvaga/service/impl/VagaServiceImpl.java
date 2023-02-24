package com.vagasproject.msvaga.service.impl;

import com.vagasproject.msvaga.dto.VagaRequest;
import com.vagasproject.msvaga.entities.Vaga;
import com.vagasproject.msvaga.enums.StatusVaga;
import com.vagasproject.msvaga.repositories.VagaRepository;
import com.vagasproject.msvaga.service.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VagaServiceImpl implements VagaService {
    private final VagaRepository vagaRepository;

    @Override
    @Transactional
    public Vaga insertVaga(VagaRequest vagaRequest) {
        Vaga vaga = Vaga.builder().name(vagaRequest.getName()).description(vagaRequest.getDescription())
                .benefit(vagaRequest.getBenefit()).requirement(vagaRequest.getRequirement())
                .statusVaga(StatusVaga.PENDENTE).initDate(LocalDate.now()).finalizedDate(null).build();

        return vagaRepository.insert(vaga);
    }
}
