package com.hotelUnip.pim.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public abstract class Pagamento implements Serializable {

    @Id
    private Integer id;
    private EstadoPagamento estado;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reserva_id")
    @MapsId
    @JsonIgnore
    private Reserva reserva;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Reserva reserva) {
        this.id = id;
        this.estado = estado;
        this.reserva = reserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
