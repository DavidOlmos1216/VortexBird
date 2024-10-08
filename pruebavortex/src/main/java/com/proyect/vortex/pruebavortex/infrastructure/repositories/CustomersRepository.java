package com.proyect.vortex.pruebavortex.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.vortex.pruebavortex.domain.entities.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    boolean existsByEmail(String email);
    Optional<Customers> findByEmail(String email);
}
