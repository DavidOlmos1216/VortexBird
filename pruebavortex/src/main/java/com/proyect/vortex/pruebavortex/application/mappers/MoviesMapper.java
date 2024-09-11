package com.proyect.vortex.pruebavortex.application.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyect.vortex.pruebavortex.application.datatransferobject.MoviesDTO;
import com.proyect.vortex.pruebavortex.domain.entities.Movies;

@Mapper(componentModel = "spring")
public interface MoviesMapper {

    Movies toEntity(MoviesDTO moviesDTO);
    MoviesDTO toDTO(Movies movies);

    List<Movies> toEntity(List<MoviesDTO> moviesDTO);
    List<MoviesDTO> toDTO(List<Movies> movies);

}
