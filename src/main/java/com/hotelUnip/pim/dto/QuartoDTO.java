package com.hotelUnip.pim.dto;


import com.hotelUnip.pim.domain.Quarto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class QuartoDTO implements Serializable {

    private Integer id;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer numero;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer andar;

    private Integer categoria;


    public QuartoDTO() {
    }

    public QuartoDTO(Quarto obj) {
        id = obj.getId();
        numero = obj.getNumero();
        andar = obj.getAndar();
        categoria = obj.getCategoria().getId();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
}


