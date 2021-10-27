package com.hotelUnip.pim.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotelUnip.pim.domain.PagamentoComBoleto;

import java.io.Serializable;
import java.util.Date;

public class PagamentoComBoletoDTO implements Serializable {

    private Integer id;

    private Integer estado;


    private Integer reserva;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;


    public PagamentoComBoletoDTO() {
    }

    public PagamentoComBoletoDTO(PagamentoComBoleto obj) {
        id = obj.getId();
        estado = obj.getEstado().getCod();
        reserva = obj.getReserva().getId();
        dataVencimento = obj.getDataVencimento();
        dataPagamento = obj.getDataPagamento();

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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}




