package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.domain.Pagamento;
import com.hotelUnip.pim.domain.PagamentoComCartao;
import com.hotelUnip.pim.dto.PagamentoComBoletoDTO;
import com.hotelUnip.pim.dto.PagamentoComCartaoDTO;
import com.hotelUnip.pim.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pagamento> find(@PathVariable Integer id){
        Pagamento obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll(){
        List<Pagamento> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }


    @PostMapping(value = "/cartao")
    public ResponseEntity<Void> insert( @Valid @RequestBody PagamentoComCartaoDTO objDto){
        Pagamento obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @PostMapping(value = "/boleto")
    public ResponseEntity<Void> insertBoleto( @Valid @RequestBody PagamentoComBoletoDTO objDto){
        Pagamento obj = service.boletoFromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCartao(@Valid @RequestBody PagamentoComCartaoDTO objDto, @PathVariable Integer id){
        Pagamento obj = service.fromDto(objDto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }




}
