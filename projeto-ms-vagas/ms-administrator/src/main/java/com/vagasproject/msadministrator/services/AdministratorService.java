package com.vagasproject.msadministrator.services;

import com.vagasproject.msadministrator.dto.AdministratorRequest;
import com.vagasproject.msadministrator.dto.AdministratorResponse;
import com.vagasproject.msadministrator.entities.Administrator;

public interface AdministratorService {
    public Administrator saveAdm(AdministratorRequest administratorRequest);
    public AdministratorResponse getAdmById(Long id);
}
