package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> find(@PathVariable Integer id){
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }


}
