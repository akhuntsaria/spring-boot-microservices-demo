package com.github.akhuntsaria.userservice.service;

import com.github.akhuntsaria.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>(Arrays.asList(
                new User(1L, "André Bazin"),
                new User(2L, "Judith Crist"),
                new User(3L, "Roger Ebert")
        ));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(Long id) {
        return users.stream().filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }
}
