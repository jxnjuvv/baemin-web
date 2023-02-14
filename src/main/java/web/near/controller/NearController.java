package web.baemin.near.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.baemin.near.dto.Address;
import web.baemin.near.service.NearService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/near/")
@RequiredArgsConstructor
public class NearController {

    private final NearService nearService;

    @GetMapping("/nearstore")
    public void nearstore(Model model) {
        List<Address> addressList = nearService.addressList();
        System.out.println("addressList = " + addressList);

        model.addAttribute("addressList", addressList);
    }

    @GetMapping("/searchstore")
    public void searchstore(Model model) {
        List<Address> addressList = nearService.addressList();
        System.out.println("addressList = " + addressList);

        model.addAttribute("addressList", addressList);
    }

}
