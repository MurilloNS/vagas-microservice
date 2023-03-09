package com.vagasproject.msvaga.dto;

import com.vagasproject.msvaga.enums.StatusVaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmVagaResponse {
    private Long idAdm;
    private String name;
    private String description;
    private String benefit;
    private String requirement;
    private StatusVaga statusVaga;
    private LocalDate initDate;
    private LocalDate finalizedDate;
}
