package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


}
