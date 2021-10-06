package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Integer> {
}
