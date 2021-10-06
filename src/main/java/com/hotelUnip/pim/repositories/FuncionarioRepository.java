package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {
}
