package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Pagamento;
import com.hotelUnip.pim.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {

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


}
