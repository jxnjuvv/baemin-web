package web.baemin.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.login.dto.User;

import java.util.Optional;

@Mapper
public interface LoginMapper {

    Optional<User> loginCheckUser(User user);

    void userInsert(User user);

    void couponInsert(User user);
}
