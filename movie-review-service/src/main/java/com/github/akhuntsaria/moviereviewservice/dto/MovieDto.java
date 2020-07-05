package com.github.akhuntsaria.moviereviewservice.dto;

public class MovieDto {

    private Long id;

    private String name;

    public MovieDto() {
    }

    public MovieDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
