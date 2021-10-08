package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Pagamento;
import com.hotelUnip.pim.repositories.PagamentoRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repo;

    public Pagamento find(Integer id){
        Optional<Pagamento> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Pagamento não encontrada! Id: " + id + ",Tipo: " + Pagamento.class.getName()));
    }

    public List<Pagamento> findAll(){
      List<Pagamento> list = repo.findAll();
      return list;

    }


}
