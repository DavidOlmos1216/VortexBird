package com.proyect.vortex.pruebavortex.application.services;

import java.util.List;

import com.proyect.vortex.pruebavortex.application.datatransferobject.MoviesDTO;

public interface MoviesService {

    MoviesDTO createMovies(MoviesDTO moviesDTO);
    MoviesDTO getMoviesById(int id) throws Exception;
    List<MoviesDTO> getMovies();

}
