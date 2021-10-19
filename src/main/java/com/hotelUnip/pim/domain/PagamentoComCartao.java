package com.hotelUnip.pim.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {


    private Integer numeroDeParcelas;


    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Reserva reserva, Integer numeroDeParcelas) {
        super(id, estado, reserva);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
