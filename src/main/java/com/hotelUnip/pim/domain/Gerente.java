package com.hotelUnip.pim.domain;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Gerente extends Funcionario{

    private Double bonificacao;

    public Gerente() {
    }

    public Gerente(Integer id, String nome, String cpf, String rua, String bairro, String numero, String cep,
                   String cidade, String estado, String telefone, String rg, Date dataNasc,
                   String matricula, String ctps, Date dataAdmissao, String cargo, Double salario,Double bonificacao ) {
        super(id, nome, cpf, rua, bairro, numero, cep, cidade, estado, telefone, rg, dataNasc, matricula, ctps, dataAdmissao, cargo, salario);
        this.bonificacao = bonificacao;
    }

    public Double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(Double bonificacao) {
        this.bonificacao = bonificacao;
    }

}
