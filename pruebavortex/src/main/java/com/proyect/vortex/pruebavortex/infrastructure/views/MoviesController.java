package com.proyect.vortex.pruebavortex.infrastructure.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.vortex.pruebavortex.application.datatransferobject.MoviesDTO;
import com.proyect.vortex.pruebavortex.application.services.IMoviesService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final IMoviesService moviesService;

    public MoviesController(IMoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MoviesDTO moviesDTO) {
        try {
            var movie = moviesService.createMovies(moviesDTO);
            if (movie != null)
                return ResponseEntity.ok(movie);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error creando movie", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MoviesDTO moviesDTO) {
        try {
            var movie = moviesService.updateMovie(moviesDTO);
            if (movie != null)
                return ResponseEntity.ok(movie);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error creando movie", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<?> getById(@RequestParam("movieId") int movieId) {
        try {
            var movie = moviesService.getMoviesById(movieId);
            if (movie != null)
                return ResponseEntity.ok(movie);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error creando movie", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            var movie = moviesService.getMovies();
            if (movie != null)
                return ResponseEntity.ok(movie);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error creando movie", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

    @GetMapping("/get-all-by-title")
    public ResponseEntity<?> getAllByTitle(@RequestParam("title") String title) {
        try {
            var movie = moviesService.getMoviesByName(title);
            if (movie != null)
                return ResponseEntity.ok(movie);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error creando movie", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

}
