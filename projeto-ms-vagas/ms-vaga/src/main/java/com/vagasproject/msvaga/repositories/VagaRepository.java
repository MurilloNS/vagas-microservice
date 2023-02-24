package com.vagasproject.msvaga.repositories;

import com.vagasproject.msvaga.entities.Vaga;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VagaRepository extends MongoRepository<Vaga, String> {
}
