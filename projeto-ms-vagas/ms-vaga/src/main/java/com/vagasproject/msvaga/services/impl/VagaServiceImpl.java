package com.vagasproject.msvaga.services.impl;

import com.vagasproject.msvaga.dto.AdmVagaResponse;
import com.vagasproject.msvaga.dto.VagaRequest;
import com.vagasproject.msvaga.entities.Vaga;
import com.vagasproject.msvaga.enums.StatusVaga;
import com.vagasproject.msvaga.repositories.VagaRepository;
import com.vagasproject.msvaga.services.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public List<AdmVagaResponse> getVagasByIdAdm(Long idAdm) {
        return vagaRepository.findByIdAdm(idAdm);
    }
}
