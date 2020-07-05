package com.github.akhuntsaria.moviereviewservice.controller;

import com.github.akhuntsaria.moviereviewservice.dto.MovieReviewDto;
import com.github.akhuntsaria.moviereviewservice.service.MovieReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class MovieReviewController {

    private final MovieReviewService movieReviewService;

    public MovieReviewController(MovieReviewService movieReviewService) {
        this.movieReviewService = movieReviewService;
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<List<MovieReviewDto>> getMovieReviewsByMovieId(@PathVariable("movieId") Long movieId) {
        return new ResponseEntity<>(movieReviewService.getMovieReviewDtosByMovieId(movieId), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<MovieReviewDto>> getMovieReviewsByUserId(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(movieReviewService.getMovieReviewDtosByUserId(userId), HttpStatus.OK);
    }
}
