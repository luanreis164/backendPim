package com.hotelUnip.pim.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelUnip.pim.domain.Pagamento;
import com.hotelUnip.pim.domain.PagamentoComCartao;
import com.hotelUnip.pim.domain.Reserva;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class PagamentoComCartaoDTO implements Serializable {

    private Integer id;

    private Integer estado;


    private Integer reserva;

    private Integer numeroDeParcelas;


    public PagamentoComCartaoDTO() {
    }

    public PagamentoComCartaoDTO(PagamentoComCartao obj) {
        id = obj.getId();
        estado = obj.getEstado().getCod();
        reserva = obj.getReserva().getId();
        numeroDeParcelas = obj.getNumeroDeParcelas();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getReserva() {
        return reserva;
    }

    public void setReserva(Integer reserva) {
        this.reserva = reserva;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}




