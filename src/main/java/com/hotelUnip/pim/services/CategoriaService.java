package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.dto.CategoriaDTO;
import com.hotelUnip.pim.repositories.CategoriaRepository;
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
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Categoria não encontrada! Id: " + id + ",Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
      List<Categoria> list = repo.findAll();
      return list;
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        Categoria newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que contém quartos!");
        }

    }

    public Page<Categoria> findPage(Integer page,Integer linesPerPage,String orderBy,String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome(),objDto.getPrecoDiaria());
    }

    private void updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
        newObj.setPrecoDiaria(obj.getPrecoDiaria());

    }

}
