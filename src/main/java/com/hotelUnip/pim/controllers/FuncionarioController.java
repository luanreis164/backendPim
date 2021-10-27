package com.hotelUnip.pim.controllers;


import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.dto.FuncionarioDTO;
import com.hotelUnip.pim.dto.FuncionarioNewDTO;
import com.hotelUnip.pim.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> find(@PathVariable Integer id){
        Funcionario obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        List<Funcionario> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody FuncionarioDTO objDto, @PathVariable Integer id){
        Funcionario obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/page")
    public ResponseEntity<Page<FuncionarioDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                     @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                     @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Funcionario> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<FuncionarioDTO> listDto = list.map(obj -> new FuncionarioDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioNewDTO objDto){
        Funcionario obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }





}
