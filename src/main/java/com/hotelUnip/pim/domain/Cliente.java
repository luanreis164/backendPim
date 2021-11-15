package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hotelUnip.pim.domain.enums.Perfil;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente extends Pessoa {


    @JsonBackReference
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas =  new ArrayList<>();



    // CONSTRUTORES ---------------------

    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String email,String senha, String cpf, String rua, String bairro, String numero, String cep, String cidade,
                   String estado, String telefone, String rg, Date dataNasc) {
        super(id, nome, email,senha, cpf, rua, bairro, numero, cep, cidade, estado, telefone, rg, dataNasc);
        addPerfil(Perfil.CLIENTE);
    }

    // GETTER / SETTERS

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
