package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Manutencao;
import com.hotelUnip.pim.dto.ManutencaoDTO;
import com.hotelUnip.pim.repositories.ManutencaoRepository;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {


    @Autowired
    private ManutencaoRepository repo;

    public Manutencao find(Integer id){
        Optional<Manutencao> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Manutencao não encontrada! Id: " + id + ",Tipo: " + Manutencao.class.getName()));
    }

    public List<Manutencao> findAll(){
      List<Manutencao> list = repo.findAll();
      return list;

    }

    public Manutencao insert(Manutencao obj){
        obj.setId(null);
        try {  repo.save(obj);}
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possivel cadastrar a manutenção!");

        } return obj;
    }



    public Manutencao update(Manutencao obj){
        Manutencao newObj = find(obj.getId());
        updateData(newObj,obj);
        try {
            return repo.save(newObj);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao foi possivel cadastrar a manutenção,tente novamente.");
        }
    }


    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não foi possivel excluir a Manutenção!");
        }

    }

    public Page<Manutencao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Manutencao fromDto(ManutencaoDTO objDto){
        return new Manutencao(objDto.getId(), objDto.getDescricao(), objDto.getDataInicio(),objDto.getDataFim(),objDto.getCustos());
    }

    private void updateData(Manutencao newObj, Manutencao obj){
        newObj.setDescricao(obj.getDescricao());
        newObj.setDataInicio(obj.getDataInicio());
        newObj.setDataFim(obj.getDataFim());
        newObj.setCustos(obj.getCustos());

    }



}
