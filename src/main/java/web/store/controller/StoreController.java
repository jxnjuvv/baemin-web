package web.baemin.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.baemin.main.dto.StoreType;
import web.baemin.main.service.MainService;
import web.baemin.review.dto.Review;
import web.baemin.store.dto.*;
import web.baemin.store.service.StoreService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/store/")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final MainService mainService;

    @GetMapping("/list")
    public void list(Model model, @RequestParam String food_category_cd) {
        List<StoreType> storeTypeList = mainService.storeTypeList();
        List<Store> storeList = storeService.storeList(food_category_cd);
        System.out.println("storeList = " + storeList);

        model.addAttribute("storeTypeList", storeTypeList);
        model.addAttribute("storeList", storeList);
        model.addAttribute("food_category_cd", food_category_cd);

    }

    @GetMapping("/read")
    public void read(Model model, @RequestParam String store_id) {
        Store store = storeService.storeRead(store_id);
        List<Menu> menuList = storeService.menuList(store_id);

        List<Review> storeReviewList = storeService.storeReviewList(store);
        System.out.println("menuList = " + menuList);

        model.addAttribute("store", store);
        model.addAttribute("menuList", menuList);
        model.addAttribute("storeReviewList", storeReviewList);
    }

    @PostMapping("/orders")
    public String modify(RedirectAttributes redirectAttributes, Orders orders){
        System.out.println("orders = " + orders);

        storeService.ordersInsert(orders);
        storeService.couponUpdate(orders);

        redirectAttributes.addFlashAttribute("msg", null);

        return "redirect:/main/index";
    }


}
