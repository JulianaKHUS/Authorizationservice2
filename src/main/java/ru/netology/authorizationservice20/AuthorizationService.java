package ru.netology.authorizationservice20;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice20.model.InvalidCredentials;
import ru.netology.authorizationservice20.model.UnauthorizedUser;
import ru.netology.authorizationservice20.model.UserRepository;

import java.util.List;

@Service

public class AuthorizationService {
    UserRepository userRepository;

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}