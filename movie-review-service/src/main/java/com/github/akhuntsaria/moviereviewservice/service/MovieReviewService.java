package com.github.akhuntsaria.moviereviewservice.service;

import com.github.akhuntsaria.moviereviewservice.dto.MovieDto;
import com.github.akhuntsaria.moviereviewservice.dto.MovieReviewDto;
import com.github.akhuntsaria.moviereviewservice.dto.UserDto;
import com.github.akhuntsaria.moviereviewservice.model.MovieReview;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieReviewService {

    private final MovieService movieService;

    private final UserService userService;

    private final List<MovieReview> movieReviews;

    public MovieReviewService(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;

        this.movieReviews = new ArrayList<>(Arrays.asList(
                new MovieReview(1L, 1L, 2L, 3, "Get off my lawn!"),
                new MovieReview(2L, 1L, 3L, 4, "Is it hard to move to Honk Kong?"),
                new MovieReview(3L, 2L, 1L, 5, "Life can not be understood, got it."),
                new MovieReview(4L, 3L, 2L, 2, null),
                new MovieReview(5L, 3L, 1L, 1, null)
        ));
    }

    public List<MovieReview> getMovieReviewsByMovieId(Long movieId) {
        return movieReviews.stream().filter(movieReview -> movieReview.getMovieId().equals(movieId))
                .collect(Collectors.toList());
    }

    public List<MovieReview> getMovieReviewsByUserId(Long userId) {
        return movieReviews.stream().filter(movieReview -> movieReview.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<MovieReviewDto> getMovieReviewDtosByMovieId(Long movieId) {
        List<MovieReview> movieReviews = this.getMovieReviewsByMovieId(movieId);
        return movieReviewsToMovieReviewDtos(movieReviews);
    }

    public List<MovieReviewDto> getMovieReviewDtosByUserId(Long userId) {
        List<MovieReview> movieReviews = this.getMovieReviewsByUserId(userId);
        return movieReviewsToMovieReviewDtos(movieReviews);
    }

    private List<MovieReviewDto> movieReviewsToMovieReviewDtos(List<MovieReview> movieReviews) {
        List<MovieReviewDto> movieReviewDtos = new ArrayList<>();

        for (MovieReview movieReview : movieReviews) {
            movieReviewDtos.add(movieReviewToMovieReviewDto(movieReview));
        }

        return movieReviewDtos;
    }

    //TODO: handle 404 responses
    private MovieReviewDto movieReviewToMovieReviewDto(MovieReview movieReview) {
        UserDto userDto = userService.getUserDto(movieReview.getUserId());
        MovieDto movieDto = movieService.getMovieDto(movieReview.getMovieId());

        return new MovieReviewDto(
                movieReview.getId(),
                movieReview.getUserId(),
                userDto.getFullName(),
                movieReview.getMovieId(),
                movieDto.getName(),
                movieReview.getRating(),
                movieReview.getReview()
            );
    }
}
