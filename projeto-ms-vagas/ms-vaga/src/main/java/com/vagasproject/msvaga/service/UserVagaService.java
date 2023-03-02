package com.vagasproject.msvaga.service;

import com.vagasproject.msvaga.entities.UserVaga;

import java.util.List;

public interface UserVagaService {
    public List<UserVaga> listVagasByEmail(String email);
}
