package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.dto.CategoriaDTO;
import com.hotelUnip.pim.services.CategoriaService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> find(@PathVariable Integer id){
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @PostMapping
    public ResponseEntity<Void> insert( @Valid @RequestBody CategoriaDTO objDto){
        Categoria obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto,@PathVariable Integer id){
        Categoria obj = service.fromDto(objDto);
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
    public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                       @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                       @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                       @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Categoria> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO','GERENTE')")
    @PostMapping(value = "/picture/{id}")
    public ResponseEntity<Void> uploadCategoriaPicture(@RequestParam(name = "file") MultipartFile multipartFile,@PathVariable Integer id){
        URI uri = service.uploadCategoriaPicture(multipartFile,id);
        return ResponseEntity.created(uri).build();

    }


}
