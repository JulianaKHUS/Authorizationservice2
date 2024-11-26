package ru.netology.authorizationservice20.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<ru.netology.authorizationservice.model.Authorities> getUserAuthorities(String user, String password) {
        if ("testuser".equals(user) && "testpass".equals(password)) {
            List<ru.netology.authorizationservice.model.Authorities> authorities = new ArrayList<>();
            authorities.add(ru.netology.authorizationservice.model.Authorities.READ);
            authorities.add(ru.netology.authorizationservice.model.Authorities.WRITE);
            return authorities;
        } else {
            return new ArrayList<>();
        }
    }
}
