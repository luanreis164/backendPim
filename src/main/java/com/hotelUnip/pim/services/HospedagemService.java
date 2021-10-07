package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Hospedagem;
import com.hotelUnip.pim.repositories.HospedagemRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository repo;

    public Hospedagem find(Integer id){
        Optional<Hospedagem> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Hospedagem não encontrada! Id: " + id + ",Tipo: " + Hospedagem.class.getName()));
    }

    public List<Hospedagem> findAll(){
      List<Hospedagem> list = repo.findAll();
      return list;

    }


}
