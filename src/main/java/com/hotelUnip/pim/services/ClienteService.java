package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.repositories.ClienteRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Cliente não encontrada! Id: " + id + ",Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll(){
      List<Cliente> list = repo.findAll();
      return list;

    }


}
