package com.proyect.vortex.pruebavortex.application.services;

import java.util.List;

import com.proyect.vortex.pruebavortex.application.datatransferobject.MoviesDTO;

public interface IMoviesService {

    MoviesDTO createMovies(MoviesDTO moviesDTO);
    MoviesDTO updateMovie(MoviesDTO moviesDTO);
    MoviesDTO getMoviesById(int id);
    List<MoviesDTO> getMovies();
    List<MoviesDTO> getMoviesByName(String movieName);

}
