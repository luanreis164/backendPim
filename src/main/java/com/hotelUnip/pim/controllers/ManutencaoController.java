package com.hotelUnip.pim.controllers;


import com.hotelUnip.pim.domain.Manutencao;
import com.hotelUnip.pim.dto.ManutencaoDTO;
import com.hotelUnip.pim.services.ManutencaoService;
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
@RequestMapping(value = "/manutencaos")
public class ManutencaoController {

    @Autowired
    private ManutencaoService service;

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Manutencao> find(@PathVariable Integer id){
        Manutencao obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @GetMapping
    public ResponseEntity<List<Manutencao>> findAll(){
        List<Manutencao> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO,GERENTE')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ManutencaoDTO objDto, @PathVariable Integer id){
        Manutencao obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/page")
    public ResponseEntity<Page<ManutencaoDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                     @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                     @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Manutencao> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<ManutencaoDTO> listDto = list.map(obj -> new ManutencaoDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ManutencaoDTO objDto){
        Manutencao obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }





}
