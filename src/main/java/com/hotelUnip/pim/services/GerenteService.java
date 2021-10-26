package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.dto.GerenteDTO;
import com.hotelUnip.pim.dto.GerenteNewDTO;
import com.hotelUnip.pim.repositories.GerenteRepository;
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
public class GerenteService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private GerenteRepository repo;

    public Gerente find(Integer id){
        Optional<Gerente> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Gerente não encontrado! Id: " + id + ",Tipo: " + Gerente.class.getName()));
    }

    public List<Gerente> findAll(){
      List<Gerente> list = repo.findAll();
      return list;

    }

    public Gerente insert(Gerente obj){
        obj.setId(null);
        try {  repo.save(obj);}
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel cadastrar um email/cpf ja cadastrado!");

        } return obj;
    }



    public Gerente update(Gerente obj){
        Gerente newObj = find(obj.getId());
        updateData(newObj,obj);
        try {
            return repo.save(newObj);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Email ja atríbuido à uma conta! Tente com outro email.");
        }
    }


    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não é possivel excluir um Gerente que tenha reserva!");
        }

    }

    public Page<Gerente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Gerente fromDto(GerenteDTO objDto){
        return new Gerente(objDto.getId(), objDto.getNome(),objDto.getEmail(),null,null,
                objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(),null,null,objDto.getMatricula(),
                objDto.getCtps(),objDto.getDataAdmissao(),objDto.getCargo(),objDto.getSalario(), objDto.getBonificacao());
    }
    public Gerente fromDto(GerenteNewDTO objDto){
        return new Gerente(objDto.getId(), objDto.getNome(),objDto.getEmail(), pe.encode(objDto.getSenha()), objDto.getCpf(),
                objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(), objDto.getRg(), objDto.getDataNasc(),objDto.getMatricula(),
                objDto.getCtps(),objDto.getDataAdmissao(),objDto.getCargo(),objDto.getSalario(), objDto.getBonificacao());
    }

    private void updateData(Gerente newObj, Gerente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setRua(obj.getRua());
        newObj.setBairro(obj.getBairro());
        newObj.setNumero(obj.getNumero());
        newObj.setCep(obj.getCep());
        newObj.setCidade(obj.getCidade());
        newObj.setEstado(obj.getEstado());
        newObj.setTelefone(obj.getTelefone());
        newObj.setMatricula(obj.getMatricula());
        newObj.setCtps(obj.getCtps());
        newObj.setDataAdmissao(obj.getDataAdmissao());
        newObj.setCargo(obj.getCargo());
        newObj.setSalario(obj.getSalario());
        newObj.setBonificacao(obj.getBonificacao());
    }



}
