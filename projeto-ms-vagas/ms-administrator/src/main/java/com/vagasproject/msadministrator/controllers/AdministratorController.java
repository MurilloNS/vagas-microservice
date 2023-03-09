package com.vagasproject.msadministrator.controllers;

import com.vagasproject.msadministrator.dto.AdministratorRequest;
import com.vagasproject.msadministrator.dto.AdministratorResponse;
import com.vagasproject.msadministrator.dto.InsertVagaRequest;
import com.vagasproject.msadministrator.entities.Administrator;
import com.vagasproject.msadministrator.services.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/adm")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;

    @PostMapping
    public ResponseEntity<Administrator> saveAdm(@Valid @RequestBody AdministratorRequest administratorRequest) {
        Administrator administrator = administratorService.saveAdm(administratorRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("{/id}")
                .buildAndExpand(administrator.getId())
                .toUri();

        return ResponseEntity.created(location).body(administrator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministratorResponse> getAdmById(@PathVariable Long id) {
        return ResponseEntity.ok(administratorService.getAdmById(id));
    }

    @PostMapping("/{idAdm}/insert-vaga")
    public ResponseEntity insertVaga(@PathVariable Long idAdm, @RequestBody InsertVagaRequest insertVagaRequest) {
        return ResponseEntity.ok(administratorService.insertVaga(idAdm, insertVagaRequest));
    }
}