package com.hotelUnip.pim.repositories;

import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    @Transactional(readOnly = true)
    Gerente findByDataReserva(Date dataReserva);

}
