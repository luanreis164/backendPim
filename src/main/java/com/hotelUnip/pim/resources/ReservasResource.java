package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Reserva;

import com.hotelUnip.pim.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reservas")
public class ReservasResource {

    @Autowired
    private ReservaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Reserva obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        List<Reserva> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }



}