package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.*;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;
import com.hotelUnip.pim.dto.PagamentoComBoletoDTO;
import com.hotelUnip.pim.dto.PagamentoComCartaoDTO;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repo;

    @Autowired
    private ReservaRepository reservaRepository;

    private BoletoService boletoService;

    public PagamentoService(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    public Pagamento find(Integer id) {
        Optional<Pagamento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Pagamento não encontrada! Id: " + id + ",Tipo: " + Pagamento.class.getName()));
    }

    public List<Pagamento> findAll() {
        List<Pagamento> list = repo.findAll();
        return list;

    }

    public Pagamento update(Pagamento obj) {
        Pagamento newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }


    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir um Pagamento que tenha reserva!");
        }

    }

    public Page<Pagamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }


    @Transactional
    public Pagamento insert(Pagamento obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Pagamento fromDto(PagamentoComCartaoDTO objDto) {
        Reserva reserva = reservaRepository.getById(objDto.getReserva());
        return new PagamentoComCartao(objDto.getId(), EstadoPagamento.PENDENTE, reserva, objDto.getNumeroDeParcelas());
    }


    public Pagamento boletoFromDto(PagamentoComBoletoDTO objDto) {
        Reserva reserva = reservaRepository.getById(objDto.getReserva());
        objDto.setDataVencimento(new Date());
        boletoService.preencherPagamentoComBoleto(objDto, objDto.getDataVencimento());
        return new PagamentoComBoleto(objDto.getId(), EstadoPagamento.PENDENTE, reserva, objDto.getDataVencimento(), null);
    }

    private void updateData(Pagamento newObj, Pagamento obj) {

        newObj.setEstado(EstadoPagamento.QUITADO);
        newObj.setReserva(obj.getReserva());
    }



}