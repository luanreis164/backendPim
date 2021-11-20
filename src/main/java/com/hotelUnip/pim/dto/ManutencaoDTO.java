package com.hotelUnip.pim.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Manutencao;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ManutencaoDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 25,message = "O tamanho deve ter entre 5 e 25 caraceteres")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataFim;

    @NotNull
    private Double custos;


    public ManutencaoDTO() {
    }

    public ManutencaoDTO(Manutencao obj) {
        id = obj.getId();
        descricao = obj.getDescricao();
        dataInicio = obj.getDataInicio();
        dataFim = obj.getDataFim();
        custos = obj.getCustos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Double getCustos() {
        return custos;
    }

    public void setCustos(Double custos) {
        this.custos = custos;
    }
}
