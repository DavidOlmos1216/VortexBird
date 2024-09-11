package com.proyect.vortex.pruebavortex.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.vortex.pruebavortex.domain.entities.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Integer> {

}
