package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.entity.Movie;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private MovieRepositoryInterface movieRepository;
    private List<Movie> movies = new ArrayList<>();

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void add(Movie movie) {
        movies.add(movie);
        System.out.println("A new movie " + movie.getTitle() + " has been added");
    }
}
