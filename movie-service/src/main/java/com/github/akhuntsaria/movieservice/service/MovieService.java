package com.github.akhuntsaria.movieservice.service;

import com.github.akhuntsaria.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>(Arrays.asList(
                new Movie(1L, "A Serious Man"),
                new Movie(2L, "No Country for Old Men"),
                new Movie(3L, "Fallen Angels")
        ));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie getMovie(Long id) {
        return movies.stream().filter(movie -> movie.getId().equals(id))
                .findFirst().orElse(null);
    }
}
