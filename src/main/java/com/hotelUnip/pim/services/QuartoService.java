package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Quarto;
import com.hotelUnip.pim.dto.QuartoDTO;
import com.hotelUnip.pim.repositories.CategoriaRepository;
import com.hotelUnip.pim.repositories.QuartoRepository;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Quarto find(Integer id){
        Optional<Quarto> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Quarto não encontrado! Id: " + id + ",Tipo: " + Quarto.class.getName()));
    }

    public List<Quarto> findAll(){
      List<Quarto> list = repo.findAll();
      return list;

    }
    @Transactional
    public Quarto insert(Quarto obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Quarto update(Quarto obj){
        Quarto newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não é possivel excluir um quarto que contém reserva!");
        }

    }

    public Page<Quarto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Quarto fromDto(QuartoDTO objDto){
        Categoria categoria =  categoriaRepository.getById(objDto.getCategoria());
        Quarto quarto = new Quarto(objDto.getId(), objDto.getNumero(),objDto.getAndar(), categoria);
        return quarto;
    }

    private void updateData(Quarto newObj, Quarto obj){
        newObj.setNumero(obj.getNumero());
        newObj.setAndar(obj.getAndar());
        newObj.setCategoria(obj.getCategoria());

    }


}
