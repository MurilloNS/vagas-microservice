package com.vagasproject.msvaga.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class UserVaga {
    @Id
    private String id;
    private String email;
    @DBRef
    private Vaga vaga;
}
