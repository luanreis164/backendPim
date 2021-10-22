package com.hotelUnip.pim.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Hospedagem;
import com.hotelUnip.pim.domain.Pagamento;
import com.hotelUnip.pim.domain.Reserva;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ReservaDTO implements Serializable {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataChegada;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataReserva;

    private Integer tempoEstadia;

    @NotNull
    private Integer cliente;

    @NotNull
    private Integer quarto;



    public ReservaDTO() {
    }

    public ReservaDTO(Reserva obj) {
        id = obj.getId();
        dataChegada = obj.getDataChegada();
        dataReserva = obj.getDataReserva();
        tempoEstadia = obj.getTempoEstadia();
        cliente = obj.getCliente().getId();
        quarto = obj.getQuarto().getId();
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




