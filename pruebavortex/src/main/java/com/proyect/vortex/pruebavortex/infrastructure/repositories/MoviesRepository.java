package com.proyect.vortex.pruebavortex.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.vortex.pruebavortex.domain.entities.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer>{
    Optional<List<Movies>> findAllByTitle(String title);
}
