package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    //1
    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    //2
    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    //3
    public String addMovieDirectorPair(String movieName, String directorName){
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    //4
    public Movie getMovieByName(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    //5
    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    //6
    public List getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    //7
    public List findAllMovies(){
        return movieRepository.findAllMovies();
    }

    //8
    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    //9
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }


}
