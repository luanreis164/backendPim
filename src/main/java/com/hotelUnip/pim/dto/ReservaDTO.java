package com.hotelUnip.pim.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ReservaDTO implements Serializable {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataReserva;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataSaida;

    private Integer tempoEstadia;

    @NotNull
    private Integer cliente;

    @NotNull
    private Integer quarto;

    private double valor;


    public ReservaDTO() {
    }

    public ReservaDTO(Reserva obj) {
        id = obj.getId();
        dataReserva = obj.getDataReserva();
        dataSaida = obj.getDataSaida();
        tempoEstadia = obj.getTempoEstadia();
        cliente = obj.getCliente().getId();
        quarto = obj.getQuarto().getId();
        valor = obj.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getTempoEstadia() {
        return tempoEstadia;
    }

    public void setTempoEstadia(Integer tempoEstadia) {
        this.tempoEstadia = tempoEstadia;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getQuarto() {
        return quarto;
    }

    public void setQuarto(Integer quarto) {
        this.quarto = quarto;
    }


}




