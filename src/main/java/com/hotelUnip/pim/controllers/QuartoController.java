package com.hotelUnip.pim.controllers;
import com.hotelUnip.pim.domain.Quarto;
import com.hotelUnip.pim.dto.QuartoDTO;
import com.hotelUnip.pim.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/quartos")
public class QuartoController {

    @Autowired
    private QuartoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Quarto> find(@PathVariable Integer id){
        Quarto obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        List<Quarto> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody QuartoDTO objDto, @PathVariable Integer id){
        Quarto obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @PutMapping(value = "/{id}/liberar")
    public ResponseEntity<Void> liberar(@PathVariable Integer id){
        Quarto obj = service.find(id);
        obj.setDisponibilidadeDiaria(true);
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
    public ResponseEntity<Page<QuartoDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                     @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                     @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Quarto> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<QuartoDTO> listDto = list.map(obj -> new QuartoDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<Void> insert( @Valid @RequestBody QuartoDTO objDto){
        Quarto obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }




}
