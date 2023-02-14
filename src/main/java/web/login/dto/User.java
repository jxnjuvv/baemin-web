package web.baemin.login.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private Long user_id;

    private String login_id;
    private String password;
    private String phone;
    private String email;
    private String grade;
    private String current_address;
    private String created_date;
    private String modified_date;
    private String status;
}
