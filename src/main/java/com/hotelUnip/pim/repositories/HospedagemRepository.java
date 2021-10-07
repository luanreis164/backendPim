package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.domain.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem,Integer> {
}
