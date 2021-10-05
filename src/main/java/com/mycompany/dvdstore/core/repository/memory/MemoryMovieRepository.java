package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.core.entity.Movie;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private MovieRepositoryInterface movieRepository;
    private List<Movie> movies = new ArrayList<>();

    private static long lastNumber = 0L;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void add(Movie movie) {
        movie.setId(++lastNumber);
        movies.add(movie);
        System.out.println("A new movie " + movie.getTitle() + " has been added");
    }

    @Override
    public Movie getById(Long id) {
        return movies.stream().filter(m -> m.getId()==id).findFirst().get();
    }

    @Override
    public List<Movie> list() {
        throw new UnsupportedOperationException();
    }
}
