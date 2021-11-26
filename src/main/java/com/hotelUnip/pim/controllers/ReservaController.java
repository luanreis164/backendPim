package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.dto.ReservaDTO;
import com.hotelUnip.pim.services.ReservaService;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.FileException;
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
@RequestMapping(value = "/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Reserva> find(@PathVariable Integer id){
        Reserva obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        List<Reserva> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ReservaDTO objDto, @PathVariable Integer id){
        Reserva obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }


    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @PutMapping(value = "/check/{id}")
    public ResponseEntity<Void> check(@Valid @RequestBody ReservaDTO objDto, @PathVariable Integer id){
        Reserva obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.check(obj);
        return ResponseEntity.noContent().build();

    }


    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ReservaDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                        @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                        @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                        @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Reserva> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<ReservaDTO> listDto = list.map(ReservaDTO::new);
        return ResponseEntity.ok().body(listDto);

    }

    @PreAuthorize("hasAnyRole('CLIENTE','FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<Void> insert( @Valid @RequestBody ReservaDTO objDto){
        Reserva obj = service.fromDto(objDto);
          obj = service.insert(obj);
          URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                  .path("/{id}").buildAndExpand(obj.getId()).toUri();
          return ResponseEntity.created(uri).build();
      }





}
