package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hotelUnip.pim.domain.enums.Perfil;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Cliente extends Pessoa {


    @JsonBackReference
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Reserva reserva;



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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
