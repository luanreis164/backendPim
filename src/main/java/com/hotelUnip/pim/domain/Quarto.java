package com.hotelUnip.pim.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numero;
    private Integer andar;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "quarto")
    @JsonIgnore
    private List<Hospedagem> hospedagens;

    @JsonIgnore
    @OneToMany(mappedBy = "quarto")
    private List<Reserva> reservas = new ArrayList<>();

    private boolean disponibilidadeDiaria;


    // CONSTRUTORES ---------------------

    public Quarto() {
        disponibilidadeDiaria = true;
    }

    public Quarto(Integer id, Integer numero, Integer andar, Categoria categoria) {
        this.id = id;
        this.numero = numero;
        this.andar = andar;
        this.categoria = categoria;
        disponibilidadeDiaria = true;
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

    public List<Hospedagem> getHospedagens() {
        return hospedagens;
    }

    public void setHospedagens(List<Hospedagem> hospedagens) {
        this.hospedagens = hospedagens;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean isDisponibilidadeDiaria() {
        return disponibilidadeDiaria;
    }

    public void setDisponibilidadeDiaria(boolean disponibilidadeDiaria) {
        this.disponibilidadeDiaria = disponibilidadeDiaria;
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
