package web.baemin.ordershistory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.baemin.login.dto.User;
import web.baemin.ordershistory.dto.OrdersHistory;
import web.baemin.ordershistory.service.OrdersHistoryService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/ordershistory/")
@RequiredArgsConstructor
public class OrdersHistoryController {

    private final OrdersHistoryService ordersHistoryService;

    @GetMapping("/list")
    public void list(Model model, @SessionAttribute(name = "loginUserSession", required = false) User loginUserSession) {
        List<OrdersHistory> ordersHistoryList = ordersHistoryService.ordersHistoryList(Long.parseLong(loginUserSession.getLogin_id()));
        model.addAttribute("ordersHistoryList", ordersHistoryList);
    }

}
