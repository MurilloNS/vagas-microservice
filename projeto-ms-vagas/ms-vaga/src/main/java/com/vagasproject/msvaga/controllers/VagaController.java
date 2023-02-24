package com.vagasproject.msvaga.controllers;

import com.vagasproject.msvaga.dto.VagaRequest;
import com.vagasproject.msvaga.entities.Vaga;
import com.vagasproject.msvaga.service.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/vaga")
@RequiredArgsConstructor
public class VagaController {
    private final VagaService vagaService;

    @PostMapping
    public ResponseEntity<Vaga> insertVaga(@Valid @RequestBody VagaRequest vagaRequest) {
        Vaga vaga = vagaService.insertVaga(vagaRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(vaga.getId())
                .toUri();

        return ResponseEntity.created(location).body(vaga);
    }
}
