package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Hospedagem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date checkin;
    private Date checkout;
    private Double valor;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;


    // CONSTRUTORES ---------------------

    public Hospedagem() {
    }

    public Hospedagem(Integer id, Date checkin, Date checkout, Double valor,
                      Funcionario funcionario,Reserva reserva,Quarto quarto) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.valor = valor;
        this.funcionario = funcionario;
        this.reserva = reserva;
        this.quarto = quarto;


    }

    // GETTER / SETTERS --------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date chckout) {
        this.checkout = checkout;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }


    // HASHCODE & EQUALS -----------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospedagem that = (Hospedagem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
