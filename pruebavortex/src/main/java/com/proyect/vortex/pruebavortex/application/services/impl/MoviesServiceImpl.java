package com.proyect.vortex.pruebavortex.application.services.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.vortex.pruebavortex.application.datatransferobject.MoviesDTO;
import com.proyect.vortex.pruebavortex.application.mappers.MoviesMapper;
import com.proyect.vortex.pruebavortex.application.services.IMoviesService;
import com.proyect.vortex.pruebavortex.domain.entities.Movies;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.MoviesRepository;

@Service
@Transactional
public class MoviesServiceImpl implements IMoviesService {

    private final MoviesRepository moviesRepository;
    private final MoviesMapper moviesMapper;

    //@Autowired
    public MoviesServiceImpl(
            MoviesRepository moviesRepository,
            MoviesMapper moviesMapper) {
        super();
        this.moviesRepository = moviesRepository;
        this.moviesMapper = moviesMapper;
    }

    @Override
    public MoviesDTO getMoviesById(int id) {
        if (id <= 0) return null;
        var movies = moviesRepository.findById(id).get();
        return moviesMapper.toDTO(movies);
    }

    @Override
    public MoviesDTO updateMovie(MoviesDTO moviesDTO) {
        if (moviesDTO == null) return null;
        Movies movies = moviesRepository.findById(moviesDTO.getId()).orElse(null);
        if (movies == null) return null;
        movies.setGender(moviesDTO.getGender());
        movies.setSynopsis(moviesDTO.getSynopsis());
        movies.setTitle(moviesDTO.getTitle());
        movies.setisActive(moviesDTO.isActive());
        movies = moviesRepository.save(movies);
        return moviesMapper.toDTO(movies);
    }

    @Override
    public MoviesDTO createMovies(MoviesDTO moviesDTO) {
        var movieEntity = moviesMapper.toEntity(moviesDTO);
        movieEntity = moviesRepository.save(movieEntity);
        return moviesMapper.toDTO(movieEntity);
    }

    @Override
    public List<MoviesDTO> getMovies() {
        var movies = moviesRepository.findAll();
        return moviesMapper.toDTO(movies);

    }

    @Override
    public List<MoviesDTO> getMoviesByName(String movieName) {
        if (StringUtils.isBlank(movieName))
            return Collections.emptyList();
        var movies = moviesRepository.findAllByTitle(movieName).orElse(Collections.emptyList());
        return moviesMapper.toDTO(movies);
    }

}
