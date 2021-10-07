package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reserva implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dataChegada;
    private Date dataReserva;
    private Integer tempoEstadia;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagem;

    public Reserva() {
    }

    public Reserva(Integer id, Date dataChegada, Date dataReserva, Integer tempoEstadia, Cliente cliente) {
        this.id = id;
        this.dataChegada = dataChegada;
        this.dataReserva = dataReserva;
        this.tempoEstadia = tempoEstadia;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Integer getTempoEstadia() {
        return tempoEstadia;
    }

    public void setTempoEstadia(Integer tempoEstadia) {
        this.tempoEstadia = tempoEstadia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
