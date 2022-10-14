package cinema.service;

import cinema.model.User;

public interface AuthenticationService {
    User register(User user);

    User register(String email, String password);
}
