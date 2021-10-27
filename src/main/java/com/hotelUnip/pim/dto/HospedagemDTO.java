package com.hotelUnip.pim.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotelUnip.pim.domain.Hospedagem;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class HospedagemDTO implements Serializable {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date checkin;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date checkout;

    @NotNull
    private Double valor;

    @NotNull
    private Integer funcionarioId;

    @NotNull
    private Integer reservaId;

    @NotNull
    private Integer quartoId;

    public HospedagemDTO() {
    }

    public HospedagemDTO(Hospedagem obj) {
        id = obj.getId();
        checkin = obj.getCheckin();
        checkout = obj.getCheckout();
        valor = obj.getValor();
        funcionarioId = obj.getFuncionario().getId();
        reservaId = obj.getReserva().getId();
        quartoId = obj.getQuarto().getId();
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

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Integer getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Integer quartoId) {
        this.quartoId = quartoId;
    }
}




