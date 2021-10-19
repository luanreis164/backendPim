package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.*;
import com.hotelUnip.pim.dto.HospedagemDTO;
import com.hotelUnip.pim.repositories.FuncionarioRepository;
import com.hotelUnip.pim.repositories.HospedagemRepository;
import com.hotelUnip.pim.repositories.QuartoRepository;
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
public class HospedagemService {

    @Autowired
    private HospedagemRepository repo;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public Hospedagem find(Integer id){
        Optional<Hospedagem> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Hospedagem não encontrada! Id: " + id + ",Tipo: " + Hospedagem.class.getName()));
    }

    public List<Hospedagem> findAll(){
      List<Hospedagem> list = repo.findAll();
      return list;

    }

    public Hospedagem insert(Hospedagem obj){
        obj.setId(null);
        try {  repo.save(obj);}
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel cadastrar um email/cpf ja cadastrado!");

        } return obj;
    }



    public Hospedagem update(Hospedagem obj){
        Hospedagem newObj = find(obj.getId());
        updateData(newObj,obj);
            return repo.save(newObj);

    }


    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não é possivel excluir uma Hospedagem reservada!");
        }

    }

    public Page<Hospedagem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Hospedagem fromDto(HospedagemDTO objDto){
        Funcionario funcionario =  funcionarioRepository.getById(objDto.getFuncionarioId());
        Reserva reserva =  reservaRepository.getById(objDto.getReservaId());
        Quarto quarto = quartoRepository.getById(objDto.getQuartoId());
        return new Hospedagem(objDto.getId(), objDto.getCheckin(),objDto.getCheckout(), objDto.getValor(),funcionario,reserva,quarto);
    }

    private void updateData(Hospedagem newObj, Hospedagem obj){
        newObj.setCheckin(obj.getCheckin());
        newObj.setCheckout(obj.getCheckout());
        newObj.setValor(obj.getValor());
        newObj.setFuncionario(obj.getFuncionario());
        newObj.setReserva(obj.getReserva());
        newObj.setQuarto(obj.getQuarto());
    }



}
