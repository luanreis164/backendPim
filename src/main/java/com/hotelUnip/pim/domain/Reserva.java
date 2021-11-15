package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reserva implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataReserva;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataSaida;

    private Integer tempoEstadia;

    private double valor;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagem;

    @JsonBackReference
    @OneToOne(mappedBy = "reserva")
    private Pagamento pagamento;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;



    // CONSTRUTORES --------------------------------

    public Reserva() {
    }

    public Reserva(Integer id, Date dataSaida, Date dataReserva, Integer tempoEstadia, Cliente cliente,Quarto quarto) {
        this.id = id;
        this.dataReserva = dataReserva;
        this.dataSaida = dataSaida;
        this.tempoEstadia = tempoEstadia;
        this.cliente = cliente;
        this.quarto = quarto;
        valor = setValor(valor);
    }

    // GETTER / SETTERS --------------------------------

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public double getValor() {
        return valor;
    }

    public double setValor(double valor) {
        valor = tempoEstadia * quarto.getCategoria().getPrecoDiaria();
        this.valor = valor;
        return valor;
    }


    // HASHCODE & EQUALS --------------------------------
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
