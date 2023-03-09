package com.vagasproject.msvaga.services.impl;

import com.vagasproject.msvaga.entities.UserVaga;
import com.vagasproject.msvaga.repositories.UserVagaRepository;
import com.vagasproject.msvaga.services.UserVagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserVagaServiceImpl implements UserVagaService {
    private final UserVagaRepository userVagaRepository;

    @Override
    public List<UserVaga> listVagasByEmail(String email) {
        return userVagaRepository.findVagasByEmail(email);
    }
}
