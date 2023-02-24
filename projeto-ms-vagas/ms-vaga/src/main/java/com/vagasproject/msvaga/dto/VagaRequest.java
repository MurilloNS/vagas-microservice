package com.vagasproject.msvaga.dto;

import com.vagasproject.msvaga.enums.StatusVaga;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VagaRequest {
    @NotNull(message = "O nome da vaga é obrigatório")
    private String name;
    @NotNull(message = "A descrição da vaga é obrigatório")
    private String description;
    private String benefit;
    private String requirement;
    private StatusVaga statusVaga;
    private LocalDate initDate;
}
