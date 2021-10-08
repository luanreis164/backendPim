package com.hotelUnip.pim.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Funcionario extends Pessoa {

    private String matricula;
    private String ctps;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAdmissao;

    private String cargo;
    private Double salario;

    @JsonBackReference
    @OneToMany(mappedBy = "funcionario",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hospedagem> hospedagens =  new ArrayList<>();

    // CONSTRUTORES ---------------------

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String email,String cpf, String rua, String bairro, String numero, String cep,
                       String cidade, String estado, String telefone, String rg, Date dataNasc,
                       String matricula, String ctps, Date dataAdmissao, String cargo, Double salario) {
        super(id, nome,email, cpf, rua, bairro, numero, cep, cidade, estado, telefone, rg, dataNasc);
        this.matricula = matricula;
        this.ctps = ctps;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.salario = salario;
    }

    // GETTER / SETTERS

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Hospedagem> getHospedagens() {
        return hospedagens;
    }

    public void setHospedagens(List<Hospedagem> hospedagens) {
        this.hospedagens = hospedagens;
    }
}
