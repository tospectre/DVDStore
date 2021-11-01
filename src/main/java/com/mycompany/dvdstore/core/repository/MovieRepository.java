package com.mycompany.dvdstore.core.repository;

import com.mycompany.dvdstore.core.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MovieRepository() {
    }

    @Override
    public Movie add(Movie movie) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO MOVIE(TITLE, GENRE, DESCRIPTION) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,movie.getTitle());
            ps.setString(2,movie.getGenre());
            ps.setString(3,movie.getDescription());
            return ps;
        }, keyHolder);

//        movie.setId(keyHolder.getKey().longValue());

        System.out.println("Database:  Movie has been Added with ID " + movie.getTitle() + " with desc : " + movie.getDescription() + ".");

        return movie;
    }

    @Override
    public List<Movie> list() {
        return jdbcTemplate.query("SELECT ID, TITLE, GENRE FROM MOVIE",
                (rs, RowNum) -> new Movie(rs.getString("TITLE"), rs.getString("GENRE"), rs.getLong("ID")));
    }

    @Override
    public Movie getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT ID, TITLE, GENRE, DESCRIPTION FROM MOVIE WHERE ID=?::bigint",
                new Object[] {id}, (rs,rowNum) -> new Movie(rs.getString("TITLE"), rs.getString("GENRE"), rs.getLong("ID"),
                         rs.getString("DESCRIPTION")));
    }
}
