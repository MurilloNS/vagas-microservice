package com.vagasproject.msuser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdate {
    @NotNull(message = "O nome é obrigatório")
    private String name;
    @NotNull(message = "A senha é obrigatória")
    private String password;
    private String resume;
}
