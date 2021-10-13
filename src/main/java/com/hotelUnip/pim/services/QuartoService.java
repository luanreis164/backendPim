package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Quarto;
import com.hotelUnip.pim.repositories.QuartoRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder.encode;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repo;

    public Quarto find(Integer id){
        Optional<Quarto> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Quarto não encontrada! Id: " + id + ",Tipo: " + Quarto.class.getName()));
    }

    public List<Quarto> findAll(){
      List<Quarto> list = repo.findAll();
      return list;

    }



}
