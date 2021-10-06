package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
