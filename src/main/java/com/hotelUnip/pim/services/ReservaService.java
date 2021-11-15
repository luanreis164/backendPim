package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.*;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;
import com.hotelUnip.pim.dto.ReservaDTO;
import com.hotelUnip.pim.repositories.*;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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

    @Autowired
    private QuartoRepository quartoRepository;


    public Reserva find(Integer id) {
        Optional<Reserva> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Reserva não encontrada! Id: " + id + ",Tipo: " + Reserva.class.getName()));
    }

    public List<Reserva> findAll() {
        List<Reserva> list = repo.findAll();
        return list;

    }


    public Reserva insert(Reserva obj) {
        obj.setId(null);

        try {
            repo.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não foi possivel cadastrar a reserva!");

        }
        return obj;
    }


    public Reserva update(Reserva obj) {
        Reserva newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);

    }


    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma Reserva reservada!");
        }

    }

    public Page<Reserva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }


    public Reserva fromDto(ReservaDTO objDto) {
        Cliente cliente = clienteRepository.getById(objDto.getCliente());
        Quarto quarto = quartoRepository.getById(objDto.getQuarto());
        return new Reserva(objDto.getId(), objDto.getDataReserva(),objDto.getDataSaida(), objDto.getTempoEstadia(), cliente, quarto);
    }

    private void updateData(Reserva newObj, Reserva obj) {
        newObj.setDataReserva(obj.getDataReserva());
        newObj.setDataSaida(obj.getDataSaida());
        newObj.setTempoEstadia(obj.getTempoEstadia());
        newObj.setCliente(obj.getCliente());
    }







}