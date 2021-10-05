package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
}
