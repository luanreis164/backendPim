package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.repositories.FuncionarioRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public Funcionario find(Integer id){
        Optional<Funcionario> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Funcionario não encontrada! Id: " + id + ",Tipo: " + Funcionario.class.getName()));
    }

    public List<Funcionario> findAll(){
      List<Funcionario> list = repo.findAll();
      return list;

    }


}
