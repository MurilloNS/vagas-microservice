package com.vagasproject.msvaga.dto;

import lombok.Data;

@Data
public class InsertVagaRequest {
    private Long idAdm;
    private String name;
    private String description;
    private String benefit;
    private String requirement;
}
