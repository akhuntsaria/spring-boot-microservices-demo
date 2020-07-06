package com.github.akhuntsaria.moviereviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewServiceApplication.class, args);
	}

}
