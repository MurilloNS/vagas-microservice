package com.vagasproject.msvaga.services;

import com.vagasproject.msvaga.entities.UserVaga;

import java.util.List;

public interface UserVagaService {
    public List<UserVaga> listVagasByEmail(String email);
}
