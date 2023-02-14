package web.baemin.main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.baemin.main.dto.StoreType;
import web.baemin.main.service.MainService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/main/")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/index")
    public void index(Model model) {
        List<StoreType> storeTypeList = mainService.storeTypeList();
        System.out.println("storeTypeList = " + storeTypeList);

        model.addAttribute("storeTypeList", storeTypeList);
    }

    @GetMapping("/storeApi")
    public void storeApi(Model model) {
    }

}
