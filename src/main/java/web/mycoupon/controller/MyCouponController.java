package web.baemin.mycoupon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.baemin.mycoupon.dto.MyCoupon;
import web.baemin.mycoupon.service.MyCouponService;
import web.baemin.login.dto.User;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mycoupon/")
@RequiredArgsConstructor
public class MyCouponController {

    private final MyCouponService myCouponService;

    @GetMapping("/list")
    public void list(Model model, @SessionAttribute(name = "loginUserSession", required = false) User loginUserSession) {
        List<MyCoupon> myCouponList = myCouponService.myCouponList(Long.parseLong(loginUserSession.getLogin_id()));
        model.addAttribute("myCouponList", myCouponList);
    }

}
