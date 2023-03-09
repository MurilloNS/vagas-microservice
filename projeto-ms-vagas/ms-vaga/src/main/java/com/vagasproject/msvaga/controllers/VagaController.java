package com.vagasproject.msvaga.controllers;

import com.vagasproject.msvaga.dto.AdmVagaResponse;
import com.vagasproject.msvaga.dto.UserVagaResponse;
import com.vagasproject.msvaga.dto.VagaRequest;
import com.vagasproject.msvaga.entities.UserVaga;
import com.vagasproject.msvaga.entities.Vaga;
import com.vagasproject.msvaga.services.UserVagaService;
import com.vagasproject.msvaga.services.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vaga")
@RequiredArgsConstructor
public class VagaController {
    private final VagaService vagaService;
    private final UserVagaService userVagaService;

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

    @GetMapping(params = "email")
    public ResponseEntity<List<UserVagaResponse>> getVagasByUser(@RequestParam("email") String email) {
        List<UserVaga> lista = userVagaService.listVagasByEmail(email);
        List<UserVagaResponse> resultList = lista.stream().map(UserVagaResponse::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/{idAdm}")
    public ResponseEntity<List<AdmVagaResponse>> getVagasByIdAdm(@PathVariable Long idAdm) {
        return ResponseEntity.ok(vagaService.getVagasByIdAdm(idAdm));
    }
}
