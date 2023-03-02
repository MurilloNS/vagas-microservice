package com.vagasproject.msadministrator.repositories;

import com.vagasproject.msadministrator.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByEmail(String email);
}
