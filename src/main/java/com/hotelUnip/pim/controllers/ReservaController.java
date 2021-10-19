package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.dto.ReservaDTO;
import com.hotelUnip.pim.services.ReservaService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaController {

    private ReservaService service;

    private ReservaController(ReservaService reservaService){
        this.service = reservaService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reserva> find(@PathVariable Integer id){
        Reserva obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        List<Reserva> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ReservaDTO objDto, @PathVariable Integer id){
        Reserva obj = service.fromDto(objDto);
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
    public ResponseEntity<Page<ReservaDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                        @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                        @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                        @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Reserva> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<ReservaDTO> listDto = list.map(obj -> new ReservaDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }
    @PostMapping
    public ResponseEntity<Void> insert( @Valid @RequestBody ReservaDTO objDto){
        Reserva obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }




}
