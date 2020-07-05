package com.github.akhuntsaria.moviereviewservice.dto;

public class MovieReviewDto {

    private Long id;

    private Long userId;

    private String userFullName;

    private Long movieId;

    private String movieName;

    private Integer rating;

    private String review;

    public MovieReviewDto() {
    }

    public MovieReviewDto(Long id, Long userId, String userFullName, Long movieId, String movieName, Integer rating, String review) {
        this.id = id;
        this.userId = userId;
        this.userFullName = userFullName;
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
