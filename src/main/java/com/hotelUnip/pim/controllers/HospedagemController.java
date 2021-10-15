package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Hospedagem;
import com.hotelUnip.pim.services.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hospedagens")
public class HospedagemController {

    @Autowired
    private HospedagemService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hospedagem> find(@PathVariable Integer id){
        Hospedagem obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll(){
        List<Hospedagem> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }



}
