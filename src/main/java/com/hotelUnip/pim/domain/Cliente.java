package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente extends Pessoa {


    @JsonBackReference
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
