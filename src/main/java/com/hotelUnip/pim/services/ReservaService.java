package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.repositories.ReservaRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repo;

    public Reserva find(Integer id){
        Optional<Reserva> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Reserva não encontrada! Id: " + id + ",Tipo: " + Reserva.class.getName()));
    }

    public List<Reserva> findAll(){
      List<Reserva> list = repo.findAll();
      return list;

    }


}
