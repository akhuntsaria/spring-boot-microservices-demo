package com.github.akhuntsaria.moviereviewservice.service;

import com.github.akhuntsaria.moviereviewservice.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private static final String USERS_API = "http://user-service/api/v1/users";

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto getUserDto(Long userId) {
        String url = USERS_API + "/" + userId;

        UserDto userDto = restTemplate.getForObject(url, UserDto.class);

        log.debug("Fetched user with id " + userId + ": " + userDto);

        return userDto;
    }
}
