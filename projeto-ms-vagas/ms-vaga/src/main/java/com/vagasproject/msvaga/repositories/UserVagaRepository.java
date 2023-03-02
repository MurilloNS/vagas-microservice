package com.vagasproject.msvaga.repositories;

import com.vagasproject.msvaga.entities.UserVaga;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserVagaRepository extends MongoRepository<UserVaga, String> {
    List<UserVaga> findVagasByEmail(String email);
}
