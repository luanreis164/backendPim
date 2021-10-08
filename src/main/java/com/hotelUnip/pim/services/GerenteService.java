package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.repositories.GerenteRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repo;

    public Gerente find(Integer id){
        Optional<Gerente> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Gerente não encontrada! Id: " + id + ",Tipo: " + Gerente.class.getName()));
    }

    public List<Gerente> findAll(){
      List<Gerente> list = repo.findAll();
      return list;

    }


}
