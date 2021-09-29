package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.core.entity.Movie;

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

    @Override
    public List<Movie> list() {
        throw new UnsupportedOperationException();
    }
}
