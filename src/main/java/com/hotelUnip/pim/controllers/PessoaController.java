package com.hotelUnip.pim.controllers;
import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> find(@PathVariable Integer id){
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('FUNCIONARIO')")
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> lista = service.findAll();
        return ResponseEntity.ok().body(lista);

    }


    @GetMapping(value = "/page")
    public ResponseEntity<Page<Pessoa>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                    @RequestParam(value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
                                                    @RequestParam(value = "orderBy",defaultValue = "nome")String orderBy,
                                                    @RequestParam(value = "direction",defaultValue = "ASC")String direction){
        Page<Pessoa> list = service.findPage(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(list);

    }


}
