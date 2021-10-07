package com.hotelUnip.pim.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numero;
    private Integer andar;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne(mappedBy = "quarto")
    @JoinColumn(name = "hospedagem_id")
    @JsonBackReference
    private Hospedagem hospedagem;


    // CONSTRUTORES ---------------------

    public Quarto() {
    }

    public Quarto(Integer id, Integer numero, Integer andar, Categoria categoria) {
        this.id = id;
        this.numero = numero;
        this.andar = andar;
        this.categoria = categoria;
    }

    // GETTER / SETTERS --------------------------------

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // HASHCODE & EQUALS --------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return Objects.equals(id, quarto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
