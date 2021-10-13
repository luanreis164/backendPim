package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaResource {

    private ReservaService service;

    private ReservaResource(ReservaService reservaService){
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



}
