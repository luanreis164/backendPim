package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Cliente extends Pessoa {


    @JsonIgnore
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Reserva reserva;



    // CONSTRUTORES ---------------------

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpf, String rua, String bairro, String numero, String cep, String cidade,
                   String estado, String telefone, String rg, Date dataNasc) {
        super(id, nome, email, cpf, rua, bairro, numero, cep, cidade, estado, telefone, rg, dataNasc);
    }

    // GETTER / SETTERS

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
