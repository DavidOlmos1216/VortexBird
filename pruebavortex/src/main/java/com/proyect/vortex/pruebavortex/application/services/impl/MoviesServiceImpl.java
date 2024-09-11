package com.proyect.vortex.pruebavortex.application.services.impl;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.vortex.pruebavortex.application.datatransferobject.MoviesDTO;
import com.proyect.vortex.pruebavortex.application.mappers.MoviesMapper;
import com.proyect.vortex.pruebavortex.application.services.MoviesService;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.MoviesRepository;

@Service
@Transactional
public class MoviesServiceImpl implements MoviesService {

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
    public MoviesDTO getMoviesById(int id) throws Exception {
        if (id <= 0) throw new NotFoundException();
        var movies = moviesRepository.findById(id).get();
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

}
