package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repo;

    public Pessoa find(Integer id){
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElse(null);

    }


}
