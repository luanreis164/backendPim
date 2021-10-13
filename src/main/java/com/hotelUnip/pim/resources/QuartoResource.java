package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Quarto;
import com.hotelUnip.pim.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/quartos")
public class QuartoResource {

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



}
