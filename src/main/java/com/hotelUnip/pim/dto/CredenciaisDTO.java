package com.hotelUnip.pim.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CredenciaisDTO implements Serializable{

    @Email
    @NotEmpty(message = "Preenchimento obrigatório")
    private String email;

    @NotEmpty(message = "Senha obrigatória")
    private String senha;

    public CredenciaisDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
