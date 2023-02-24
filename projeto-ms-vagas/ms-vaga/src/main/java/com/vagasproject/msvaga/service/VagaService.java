package com.vagasproject.msvaga.service;

import com.vagasproject.msvaga.dto.VagaRequest;
import com.vagasproject.msvaga.entities.Vaga;

public interface VagaService {
    Vaga insertVaga(VagaRequest vagaRequest);
}
