package web.baemin.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.baemin.login.dto.User;
import web.baemin.login.service.KakaoService;
import web.baemin.login.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/login/")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final KakaoService kakaoService;

    @GetMapping("/index")
    public void index(){
    }

    @PostMapping("/loginCheck")
    public String loginCheck(User user, RedirectAttributes redirectAttributes, HttpSession session, Model model){
        Optional<User> User = loginService.loginCheckUser(user);
        System.out.println("User = " + User.toString());

        if (User.isEmpty()) { // 로그인 실패
            System.out.println("로그인 실패");
            redirectAttributes.addFlashAttribute("msg", "로그인을 실패했습니다.");
        } else { // 로그인 성공
            System.out.println("로그인 성공");
            session.setAttribute("loginUserSession", user);
        }

        return "redirect:/main/index";
    }

    @GetMapping("/logoutProc")
    public String logoutProc(@SessionAttribute(name = "loginUserSession", required = false) User loginUserSession, HttpSession session){
        System.out.println("loginUserSession = " + loginUserSession);

        User user = new User();
        user.setLogin_id(loginUserSession.getLogin_id());
        Optional<User> User = loginService.loginCheckUser(user);
        System.out.println("User = " + User);


        session.invalidate();

        return "redirect:/main/index";
    }

    @GetMapping("/kakao/success")
    public String kakaoCallback(@RequestParam String code, HttpSession session) {
        System.out.println("code = " + code);

        String access_Token = kakaoService.getKaKaoAccessToken(code);
        System.out.println("access_Token = " + access_Token);

        String login_id = Integer.toString(kakaoService.createKakaoUser(access_Token));

        User user = new User();
        user.setLogin_id(login_id);
        Optional<User> User = loginService.loginCheckUser(user);
        System.out.println("User = " + User.toString());

        if (User.isEmpty()) {
            loginService.userInsert(user);
        }

        session.setAttribute("loginUserSession", user);

        return "redirect:/main/index";

    }


}
