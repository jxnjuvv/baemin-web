package web.baemin.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.baemin.login.dto.User;
import web.baemin.login.mapper.LoginMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {


    private final LoginMapper loginMapper;

    @Override
    public Optional<User> loginCheckUser(User user) {

        Optional<User> User = loginMapper.loginCheckUser(user);

        return User;
    }

    @Override
    @Transactional
    public void userInsert(User user) {
        loginMapper.userInsert(user);
        loginMapper.couponInsert(user);
    }



}
