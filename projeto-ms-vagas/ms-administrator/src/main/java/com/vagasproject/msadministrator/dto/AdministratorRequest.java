package com.vagasproject.msadministrator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministratorRequest {
    @NotNull(message = "O nome do administrador é obrigatório")
    private String name;
    @Email(message = "E-mail inválidp")
    private String email;
    @NotNull(message = "A senha é obrigatória")
    private String password;
}
