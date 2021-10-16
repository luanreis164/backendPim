package com.hotelUnip.pim.dto;


import com.hotelUnip.pim.domain.Cliente;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class ClienteNewDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 25,message = "O tamanho deve ter entre 5 e 25 caraceteres")
    private String nome;

    @Email
    @NotEmpty(message = "Preenchimento obrigatório")
    private String email;

    @CPF
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpf;


    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 25,message = "O tamanho deve ter entre 5 e 25 caraceteres")
    private String rua;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 35,message = "O tamanho deve ter entre 3 e 35 caraceteres")
    private String bairro;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 22,message = "O tamanho deve ter entre 1 e 20 caraceteres")
    private String numero;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 7, max = 9,message = "O tamanho deve ter o formato correto")
    private String cep;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 35,message = "O tamanho deve ter entre 5 e 35 caraceteres")
    private String cidade;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 25,message = "O tamanho deve ter entre 5 e 25 caraceteres")
    private String estado;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 10, max = 17,message = "O tamanho deve ter o formato correto")
    private String telefone;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 10, max = 17,message = "O tamanho deve ter o formato correto")
    private String rg;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasc;



    public ClienteNewDTO() {
    }

    public ClienteNewDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
        cpf = obj.getCpf();
        rua = obj.getRua();
        bairro = obj.getBairro();
        numero = obj.getNumero();
        cep = obj.getCep();
        cidade = obj.getCidade();
        estado = obj.getEstado();
        telefone = obj.getTelefone();
        rg = obj.getRg();
        dataNasc = obj.getDataNasc();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
