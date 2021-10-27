package com.hotelUnip.pim.controllers;
import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.dto.GerenteDTO;
import com.hotelUnip.pim.dto.GerenteNewDTO;
import com.hotelUnip.pim.services.GerenteService;
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
@RequestMapping(value = "/gerentes")
@PreAuthorize("hasAnyRole('GERENTE')")
public class GerenteController {

    @Autowired
    private GerenteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Gerente> find(@PathVariable Integer id){
        Gerente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Gerente>> findAll(){
        List<Gerente> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody GerenteDTO objDto, @PathVariable Integer id){
        Gerente obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/page")
    public ResponseEntity<Page<GerenteDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                         @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                         @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                         @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Gerente> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<GerenteDTO> listDto = list.map(GerenteDTO::new);
        return ResponseEntity.ok().body(listDto);

    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody GerenteNewDTO objDto){
        Gerente obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }






}
