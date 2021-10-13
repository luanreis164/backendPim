package com.hotelUnip.pim.resources;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> find(@PathVariable Integer id){
        Funcionario obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        List<Funcionario> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }



}
