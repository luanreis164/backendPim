package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Funcionario;
import com.hotelUnip.pim.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {

    @Transactional(readOnly = true)
    Funcionario findByEmail(String email);

}
