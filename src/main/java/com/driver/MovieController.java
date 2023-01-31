package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response=movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //2
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String response=movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //3
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName){
        String response=movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //4
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie response=movieService.getMovieByName(name);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //5
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director response=movieService.getDirectorByName(name);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //6
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> response=movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //7
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> response=movieService.findAllMovies();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //8
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director") String directorName){
        String response=movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    //9
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String response=movieService.deleteAllDirectors();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
