package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente,Integer> {
    @Transactional(readOnly = true)
    Gerente findByEmail(String email);

}
