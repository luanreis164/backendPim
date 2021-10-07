package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Hospedagem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date checkin;
    private Date chckout;
    private Double valor;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @OneToOne(cascade = CascadeType.MERGE)
    private Reserva reserva;

    public Hospedagem() {
    }

    public Hospedagem(Integer id, Date checkin, Date chckout, Double valor, Funcionario funcionario,Reserva reserva) {
        this.id = id;
        this.checkin = checkin;
        this.chckout = chckout;
        this.valor = valor;
        this.funcionario = funcionario;
        this.reserva = reserva;
    }

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

    public Date getChckout() {
        return chckout;
    }

    public void setChckout(Date chckout) {
        this.chckout = chckout;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
