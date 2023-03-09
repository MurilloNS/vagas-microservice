package com.vagasproject.msvaga.services;

import com.vagasproject.msvaga.dto.AdmVagaResponse;
import com.vagasproject.msvaga.dto.VagaRequest;
import com.vagasproject.msvaga.entities.Vaga;

import java.util.List;

public interface VagaService {
    Vaga insertVaga(VagaRequest vagaRequest);

    List<AdmVagaResponse> getVagasByIdAdm(Long idAdm);
}
