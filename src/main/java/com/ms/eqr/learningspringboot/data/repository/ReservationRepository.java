package com.ms.eqr.learningspringboot.data.repository;

import com.ms.eqr.learningspringboot.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
