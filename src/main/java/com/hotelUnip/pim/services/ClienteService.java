package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.enums.Perfil;
import com.hotelUnip.pim.dto.ClienteDTO;
import com.hotelUnip.pim.dto.ClienteNewDTO;
import com.hotelUnip.pim.repositories.ClienteRepository;
import com.hotelUnip.pim.security.UserSS;
import com.hotelUnip.pim.services.exceptions.AuthorizationException;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){

        UserSS user = UserService.authenticated();
        if ( user == null || !user.hasRole(Perfil.FUNCIONARIO) && !id.equals(user.getId())){
            throw new AuthorizationException("Acesso negado");
        }
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Cliente não encontrada! Id: " + id + ",Tipo: " + Cliente.class.getName()));
    }

    public Cliente findByEmail(String email){

        UserSS user = UserService.authenticated();
        if(user == null){
            throw new AuthorizationException("Acesso negado");
        }

        Cliente obj = repo.findByEmail(email);
        if (obj == null){
            throw  new ObjectNotFoundException("Cliente não encontrado! Id:" + user.getId()+ ", Tipo: " + Cliente.class.getName());
        }
        return obj;

    }

    public List<Cliente> findAll(){
      List<Cliente> list = repo.findAll();
      return list;

    }

    public Cliente insert(Cliente obj){
        obj.setId(null);
        try {  repo.save(obj);}
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel cadastrar um email/cpf ja cadastrado!");

        } return obj;
    }



    public Cliente update(Cliente obj){
        Cliente newObj = find(obj.getId());
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
            throw new DataIntegrityException("Não é possivel excluir um Cliente que tenha reserva!");
        }

    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }


    public Cliente fromDto(ClienteDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(),objDto.getEmail(),null, objDto.getCpf(),
                           objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                           objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(), objDto.getRg(), objDto.getDataNasc());
    }
    public Cliente fromDto(ClienteNewDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(),objDto.getEmail(), pe.encode(objDto.getSenha()), objDto.getCpf(),
                objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(), objDto.getRg(), objDto.getDataNasc());
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setCpf(obj.getCpf());
        newObj.setRua(obj.getRua());
        newObj.setBairro(obj.getBairro());
        newObj.setNumero(obj.getNumero());
        newObj.setCep(obj.getCep());
        newObj.setCidade(obj.getCidade());
        newObj.setEstado(obj.getEstado());
        newObj.setTelefone(obj.getTelefone());
        newObj.setRg(obj.getRg());
    }



}
