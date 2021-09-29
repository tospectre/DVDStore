package com.mycompany.dvdstore.core.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class MovieController {

//    @Autowired
//    private MovieServiceInterface movieService;

//    public MovieServiceInterface getMovieService() {
//        return movieService;
//    }
//
//    public void setMovieService(MovieServiceInterface movieService) {
//        this.movieService = movieService;
//    }

    public void addUsingConsole() {
        System.out.println("Pour ajouter un film, merci de saisir son titre :");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        System.out.println("son Genre :");
        String gender = sc.nextLine();
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(gender);

//        movieService.registerMovie(movie);
    }
}
