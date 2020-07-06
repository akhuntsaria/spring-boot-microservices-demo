package com.github.akhuntsaria.moviereviewservice.service;

import com.github.akhuntsaria.moviereviewservice.dto.MovieDto;
import com.github.akhuntsaria.moviereviewservice.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    private final RestTemplate restTemplate;

    private static final String USERS_API = "http://movie-service/api/v1/movies";

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MovieDto getMovieDto(Long movieId) {
        String url = USERS_API + "/" + movieId;

        MovieDto movieDto = restTemplate.getForObject(url, MovieDto.class);

        log.debug("Fetched movie with id " + movieId + ": " + movieDto);

        return movieDto;
    }
}
