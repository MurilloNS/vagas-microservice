package com.vagasproject.msvaga.entities;

import com.vagasproject.msvaga.enums.StatusVaga;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "vagas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vaga {
    @Id
    private String id;
    private String name;
    private String description;
    private String benefit;
    private String requirement;
    private StatusVaga statusVaga;
    private LocalDate initDate;
    private LocalDate finalizedDate;
}
