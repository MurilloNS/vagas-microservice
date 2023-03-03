package com.vagasproject.msadministrator.services.impl;

import com.vagasproject.msadministrator.dto.AdministratorRequest;
import com.vagasproject.msadministrator.dto.AdministratorResponse;
import com.vagasproject.msadministrator.dto.InsertVagaRequest;
import com.vagasproject.msadministrator.entities.Administrator;
import com.vagasproject.msadministrator.rabbitmq.InsertVagaPublisher;
import com.vagasproject.msadministrator.repositories.AdministratorRepository;
import com.vagasproject.msadministrator.services.AdministratorService;
import com.vagasproject.msadministrator.services.exceptions.EmailAlreadyExist;
import com.vagasproject.msadministrator.services.exceptions.ErrorInsertVagaException;
import com.vagasproject.msadministrator.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;
    private final InsertVagaPublisher insertVagaPublisher;

    @Override
    @Transactional
    public Administrator saveAdm(AdministratorRequest administratorRequest) {
        if (administratorRepository.findByEmail(administratorRequest.getEmail()) == null) {
            Administrator administrator = Administrator.builder()
                    .name(administratorRequest.getName()).email(administratorRequest.getEmail())
                    .password(administratorRequest.getPassword()).build();

            return administratorRepository.save(administrator);
        } else {
            throw new EmailAlreadyExist("Esse e-mail já está cadastrado!");
        }
    }

    @Override
    public AdministratorResponse getAdmById(Long id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Administrador não encontrado!"));
        return AdministratorResponse.builder().name(administrator.getName()).email(administrator.getEmail()).build();
    }

    @Override
    public InsertVagaRequest insertVaga(InsertVagaRequest insertVagaRequest) {
        try {
            return(insertVagaPublisher.insertVaga(insertVagaRequest));
        } catch (Exception e) {
            throw new ErrorInsertVagaException(e.getMessage());
        }
    }
}