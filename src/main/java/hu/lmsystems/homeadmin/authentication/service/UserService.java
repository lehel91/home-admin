package hu.lmsystems.homeadmin.authentication.service;

import hu.lmsystems.homeadmin.authentication.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}