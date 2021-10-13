package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.services.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gerentes")
public class GerenteResource {

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



}
