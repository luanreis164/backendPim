package com.hotelUnip.pim.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
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
    @OneToOne(mappedBy = "quarto")
    private Reserva reserva;

    private boolean disponibilidadeDiaria;


    // CONSTRUTORES ---------------------

    public Quarto() {
        disponibilidadeDiaria = true;
    }

    public Quarto(Integer id, Integer numero, Integer andar, Categoria categoria, boolean disponibilidadeDiaria) {
        this.id = id;
        this.numero = numero;
        this.andar = andar;
        this.categoria = categoria;
        this.disponibilidadeDiaria = true;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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
