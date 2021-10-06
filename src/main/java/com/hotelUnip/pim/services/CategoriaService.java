package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.repositories.CategoriaRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Categoria não encontrada! Id: " + id + ",Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
      List<Categoria> list = repo.findAll();
      return list;

    }


}
