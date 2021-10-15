package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.repositories.PessoaRepository;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public List<Pessoa> findAll(){
      List<Pessoa> list = repo.findAll();
      return list;

    }


    public Page<Pessoa> findPage(Integer page,Integer linesPerPage,String orderBy,String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }

}




