package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.dto.FuncionarioDTO;
import com.hotelUnip.pim.dto.FuncionarioNewDTO;
import com.hotelUnip.pim.repositories.FuncionarioRepository;
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
public class FuncionarioService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private FuncionarioRepository repo;

    public Funcionario find(Integer id){
        Optional<Funcionario> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Funcionario não encontrado! Id: " + id + ",Tipo: " + Funcionario.class.getName()));
    }

    public List<Funcionario> findAll(){
        List<Funcionario> list = repo.findAll();
        return list;

    }

    public Funcionario insert(Funcionario obj){
        obj.setId(null);
        try {  repo.save(obj);}
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel cadastrar um email/cpf ja cadastrado!");

        } return obj;
    }



    public Funcionario update(Funcionario obj){
        Funcionario newObj = find(obj.getId());
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
            throw new DataIntegrityException("Não é possivel excluir um Funcionario que tenha reserva!");
        }

    }

    public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Funcionario fromDto(FuncionarioDTO objDto){
        return new Funcionario(objDto.getId(), objDto.getNome(),objDto.getEmail(), null,null,
                objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(),null,null,objDto.getMatricula(),
                objDto.getCtps(),objDto.getDataAdmissao(),objDto.getCargo(),objDto.getSalario());
    }
    public Funcionario fromDto(FuncionarioNewDTO objDto){
        return new Funcionario(objDto.getId(), objDto.getNome(),objDto.getEmail(),pe.encode(objDto.getSenha()),objDto.getCpf(),
                objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(), objDto.getRg(), objDto.getDataNasc(),objDto.getMatricula(),
                objDto.getCtps(),objDto.getDataAdmissao(),objDto.getCargo(),objDto.getSalario());
    }

    private void updateData(Funcionario newObj, Funcionario obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
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
    }



}
