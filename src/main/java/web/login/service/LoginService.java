package web.baemin.login.service;

import web.baemin.login.dto.User;

import java.util.Optional;

public interface LoginService {


    Optional<User> loginCheckUser(User user);

    void userInsert(User user);
}
