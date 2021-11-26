package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.dto.ClienteDTO;
import com.hotelUnip.pim.dto.ClienteNewDTO;
import com.hotelUnip.pim.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> lista = service.findAll();
        List<ClienteDTO> listaDto = lista.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDto);
    }

    @PreAuthorize("hasAnyRole('CLIENTE','FUNCIONARIO')")
    @GetMapping(value = "/email")
    public ResponseEntity<ClienteDTO> find(@RequestParam(value = "value") String email){
        Cliente obj = service.findByEmail(email);
                return ResponseEntity.ok().body(new ClienteDTO(obj));

    }

    @PreAuthorize("hasAnyRole('CLIENTE','FUNCIONARIO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){
        Cliente obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                       @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                       @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                       @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Cliente> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto){
        Cliente obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


}
