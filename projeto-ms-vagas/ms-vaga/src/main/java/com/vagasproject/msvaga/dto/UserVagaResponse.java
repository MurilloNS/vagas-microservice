package com.vagasproject.msvaga.dto;

import com.vagasproject.msvaga.entities.UserVaga;
import com.vagasproject.msvaga.enums.StatusVaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVagaResponse {
    private String name;
    private String description;
    private String benefit;
    private String requirement;
    private StatusVaga statusVaga;

    public static UserVagaResponse fromModel(UserVaga model) {
        return new UserVagaResponse(
                model.getVaga().getName(),
                model.getVaga().getDescription(),
                model.getVaga().getBenefit(),
                model.getVaga().getRequirement(),
                model.getVaga().getStatusVaga()
        );
    }
}
