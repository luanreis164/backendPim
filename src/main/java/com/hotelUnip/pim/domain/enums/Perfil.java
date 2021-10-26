package com.hotelUnip.pim.domain.enums;

import org.springframework.security.core.parameters.P;

public enum Perfil {

    FUNCIONARIO(1,"ROLE_FUNCIONARIO"),
    GERENTE(2,"ROLE_GERENTE"),
    CLIENTE(3,"ROLE_CLIENTE");

    private int cod;
    private String descricao;

    Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }
    public String getDescricao(){
        return descricao;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null) {
            return null;
        }
        for (Perfil x : Perfil.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido! ID: " + cod);

    }




}
