package com.hotelUnip.pim.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelUnip.pim.domain.enums.Perfil;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Pessoa implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nome;

        @Column(unique = true)
        private String email;

        private String senha;

        @CPF
        @Column(unique = true)
        private String cpf;

        private String rua;
        private String bairro;
        private String numero;
        private String cep;
        private String cidade;
        private String estado;
        private String telefone;
        private String rg;

        @JsonFormat(pattern = "dd/MM/yyyy")
        private Date dataNasc;

        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "PERFIS")
        private Set<Integer> perfis = new HashSet<>();

        // CONSTRUTORES ---------------------

        public Pessoa() {
        }

        public Pessoa(Integer id, String nome, String email,String senha , String cpf, String rua, String bairro, String numero, String cep,
                      String cidade, String estado, String telefone, String rg, Date dataNasc) {
                this.id = id;
                this.nome = nome;
                this.email = email;
                this.senha = senha;
                this.cpf = cpf;
                this.rua = rua;
                this.bairro = bairro;
                this.numero = numero;
                this.cep = cep;
                this.cidade = cidade;
                this.estado = estado;
                this.telefone = telefone;
                this.rg = rg;
                this.dataNasc = dataNasc;
        }

        // GETTER / SETTERS

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

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
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

        public String getCep() {
                return cep;
        }

        public void setCep(String cep) {
                this.cep = cep;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }

        public Set<Perfil> getPerfis(){
                return perfis.stream().map( x -> Perfil.toEnum(x)).collect(Collectors.toSet());
        }

        public void addPerfil(Perfil perfil){
                perfis.add(perfil.getCod());
        }

// HASHCODE & EQUALS

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pessoa pessoa = (Pessoa) o;
                return Objects.equals(id, pessoa.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }


}
