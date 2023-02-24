package com.vagasproject.msvaga.enums;

public enum StatusVaga {
    PENDENTE("Em Andamento"), ENCERRADO("Encerrado");

    private String status;

    StatusVaga(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
