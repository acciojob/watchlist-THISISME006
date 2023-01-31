package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movies;
    private HashMap<String, Director> directors;
    private HashMap<String, List<String>> directorMoviePairing;

    // movies and directors map the name String to the object of Movie and Director respectively
    // director movie pairing is used to store director and list of his movies by name


    public MovieRepository() {
        movies=new HashMap<>();
        directors=new HashMap<>();
        directorMoviePairing=new HashMap<>();
    }

    //1
    public String addMovie(Movie movie){
        movies.put(movie.getName(), movie);
        return "Movie added";
    }

    //2
    public String addDirector(Director director){
        directors.put(director.getName(), director);
        return "Director added";
    }

    //3
    public String addMovieDirectorPair(String movieName, String directorName){
        if(!movies.containsKey(movieName) || !directors.containsKey(directorName)){
            return "Movie or Director missing";
        }

        //add director if not exist in pairing
        if(!directorMoviePairing.containsKey(directorName)){
            directorMoviePairing.put(directorName,new ArrayList<>());
        }

        //add movie to list of director movies
        directorMoviePairing.get(directorName).add(movieName);

        return "paired Successfully";
    }

    //4
    public Movie getMovieByName(String movieName){
        return movies.get(movieName);
    }

    //5
    public Director getDirectorByName(String directorName){
        return directors.get(directorName);
    }

    //6
    public List getMoviesByDirectorName(String directorName){
        List<String> result=new ArrayList<>();

        if(directorMoviePairing.containsKey(directorName)){
            result=directorMoviePairing.get(directorName);
        }

        return result;
    }

    //7
    public List findAllMovies(){
        List<String> result=new ArrayList<>();

        for(String movieName:movies.keySet()){
            result.add(movieName);
        }
        return result;
    }

    //8
    public String deleteDirectorByName(String directorName){
        //if no director
        if(!directors.containsKey(directorName)){
            return "No such director";
        }

        // if movies are made by director
        if(directorMoviePairing.containsKey(directorName)){
            //get list of movies by director
            List<String> movieList = directorMoviePairing.get(directorName);

            //removing list of movies by director
            for (String movieName : movieList) {
                movies.remove(movieName);
            }

            //removing director movie paring as director is being removed
            directorMoviePairing.remove(directorName);
        }

        //removing director from directors
        directors.remove(directorName);

        return "Director "+directorName+" and movies if any deleted";
    }


    //9
    public String deleteAllDirectors(){

        //removing all directors by making a fresh map
        directors.clear();

        //removing movies by  directors
        for(List<String> movieList: directorMoviePairing.values()){
            for(String movieName: movieList){
                if(movies.containsKey(movieName)){
                    movies.remove(movieName);
                }
            }
        }

        //removing all pairings
        directorMoviePairing.clear();

        return "All directors removed";
    }
}
