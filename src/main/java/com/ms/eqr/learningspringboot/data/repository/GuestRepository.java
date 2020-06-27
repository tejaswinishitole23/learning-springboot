package com.ms.eqr.learningspringboot.data.repository;

import com.ms.eqr.learningspringboot.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
