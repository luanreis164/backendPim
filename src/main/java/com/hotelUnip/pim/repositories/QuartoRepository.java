package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Quarto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Integer> {

    Page<Quarto> findDistinctByNumeroContainingAndCategoria(String numero,Optional<Categoria> categoria, Pageable pageRequest);

}
