package com.hari.movie_service.controller;

import com.hari.movie_service.DTO.MovieRequest;
import com.hari.movie_service.DTO.MovieResponse;
import com.hari.movie_service.entity.Movie;
import com.hari.movie_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/")
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/with-genre")
    public ResponseEntity<List<Map<String,Object>>> getAllMoviesWithGenre(){
        return movieService.getAllMoviesWithGenre();
    }

    @PostMapping("/")
    public ResponseEntity<Movie> saveMovie(@RequestBody MovieRequest movie){
        return movieService.saveMovie(movie);
    }


    @GetMapping("/get-All")
    public ResponseEntity<List<Map<String,Object>>> getAll(){
        return movieService.getAll();
    }







}
