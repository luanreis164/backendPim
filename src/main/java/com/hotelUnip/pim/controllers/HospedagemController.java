package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Hospedagem;
import com.hotelUnip.pim.domain.Hospedagem;
import com.hotelUnip.pim.dto.HospedagemDTO;
import com.hotelUnip.pim.services.HospedagemService;
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
@RequestMapping(value = "/hospedagens")
public class HospedagemController {

    @Autowired
    private HospedagemService service;

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Hospedagem> find(@PathVariable Integer id){
        Hospedagem obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    public ResponseEntity<List<Hospedagem>> findAll(){
        List<Hospedagem> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody HospedagemDTO objDto, @PathVariable Integer id){
        Hospedagem obj = service.fromDto(objDto);
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
    public ResponseEntity<Page<HospedagemDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                    @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                    @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                    @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Hospedagem> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<HospedagemDTO> listDto = list.map(obj -> new HospedagemDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @PostMapping
    public ResponseEntity<Void> insert( @Valid @RequestBody HospedagemDTO objDto){
        Hospedagem obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }






}
