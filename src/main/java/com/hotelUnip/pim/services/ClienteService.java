package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.dto.ClienteDTO;
import com.hotelUnip.pim.repositories.ClienteRepository;
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
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Cliente não encontrada! Id: " + id + ",Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll(){
      List<Cliente> list = repo.findAll();
      return list;

    }

    public Cliente update(Cliente obj){
        Cliente newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
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
        return new Cliente(objDto.getId(), objDto.getNome(),objDto.getEmail(),null,
                           objDto.getRua(),objDto.getBairro(),objDto.getNumero(),
                           objDto.getCep(),objDto.getCidade(),objDto.getEstado(), objDto.getTelefone(),null,null);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setRua(obj.getRua());
        newObj.setBairro(obj.getBairro());
        newObj.setNumero(obj.getNumero());
        newObj.setCep(obj.getCep());
        newObj.setCidade(obj.getCidade());
        newObj.setEstado(obj.getEstado());
        newObj.setTelefone(obj.getTelefone());
    }


}
