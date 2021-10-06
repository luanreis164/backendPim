package com.hotelUnip.pim.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Cliente extends Pessoa {


    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Reserva reserva;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpf, String rua, String bairro, String numero, String cep, String cidade,
                   String estado, String telefone, String rg, Date dataNasc) {
        super(id, nome, email, cpf, rua, bairro, numero, cep, cidade, estado, telefone, rg, dataNasc);
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
