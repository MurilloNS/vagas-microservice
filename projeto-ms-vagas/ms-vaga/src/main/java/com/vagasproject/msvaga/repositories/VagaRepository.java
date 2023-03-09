package com.vagasproject.msvaga.repositories;

import com.vagasproject.msvaga.dto.AdmVagaResponse;
import com.vagasproject.msvaga.entities.Vaga;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VagaRepository extends MongoRepository<Vaga, String> {
    List<AdmVagaResponse> findByIdAdm(Long idAdm);
}
