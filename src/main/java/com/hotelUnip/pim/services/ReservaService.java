package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.*;
import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.dto.ReservaDTO;
import com.hotelUnip.pim.repositories.ClienteRepository;
import com.hotelUnip.pim.repositories.HospedagemRepository;
import com.hotelUnip.pim.repositories.PagamentoRepository;
import com.hotelUnip.pim.repositories.ReservaRepository;
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
public class ReservaService {

    @Autowired
    private ReservaRepository repo;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Reserva find(Integer id){
        Optional<Reserva> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Reserva não encontrada! Id: " + id + ",Tipo: " + Reserva.class.getName()));
    }

    public List<Reserva> findAll(){
      List<Reserva> list = repo.findAll();
      return list;

    }


    public Reserva insert(Reserva obj){
        obj.setId(null);
        try {  repo.save(obj);}
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel cadastrar um email/cpf ja cadastrado!");

        } return obj;
    }



    public Reserva update(Reserva obj){
        Reserva newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);

    }


    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não é possivel excluir uma Reserva reservada!");
        }

    }

    public Page<Reserva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Reserva fromDto(ReservaDTO objDto){
        Cliente cliente =  clienteRepository.getById(objDto.getCliente());
        return new Reserva(objDto.getId(), objDto.getDataChegada(),objDto.getDataReserva(), objDto.getTempoEstadia(),cliente);
    }

    private void updateData(Reserva newObj, Reserva obj){
        newObj.setDataChegada(obj.getDataChegada());
        newObj.setDataReserva(obj.getDataReserva());
        newObj.setTempoEstadia(obj.getTempoEstadia());
        newObj.setCliente(obj.getCliente());
    }



}
