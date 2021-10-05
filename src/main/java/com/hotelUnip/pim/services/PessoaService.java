package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.repositories.PessoaRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repo;

    public Pessoa find(Integer id){
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Pessoa não encontrada! Id: " + id + ",Tipo: " + Pessoa.class.getName()));
    }

    public List<Pessoa> finAll(){
      List<Pessoa> list = repo.findAll();
      return list;

    }


}
