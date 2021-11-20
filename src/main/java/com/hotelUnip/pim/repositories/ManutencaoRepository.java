package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao,Integer> {
}
