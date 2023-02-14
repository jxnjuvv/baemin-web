package web.baemin.review.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.baemin.login.dto.User;
import web.baemin.review.dto.Review;
import web.baemin.review.dto.ReviewPicture;
import web.baemin.review.service.ReviewService;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/review/")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/list")
    public void index(Model model,@SessionAttribute(name = "loginUserSession", required = false) User loginUserSession) {
        List<Review> reviewList = reviewService.reviewList(Long.parseLong(loginUserSession.getLogin_id()));

        model.addAttribute("reviewList", reviewList);
    }

    @GetMapping("/register")
    public void register(Model model,Review review){

        model.addAttribute("review", review);

    }

    @PostMapping("/register")
    public String register(RedirectAttributes redirectAttributes, Review review, MultipartFile file){

        reviewService.reviewInsert(review);

        redirectAttributes.addFlashAttribute("result", review.getReview_id());

        return "redirect:/review/list";
    }


    @GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<ReviewPicture>> reviewPictureList(Long review_id) {

        return new ResponseEntity<>(reviewService.reviewPictureList(review_id), HttpStatus.OK);

    }

    @PostMapping("/delete")
    public String delete(RedirectAttributes redirectAttributes, Review review){

        reviewService.reviewDelete(review);

        return "redirect:/review/list";
    }

}
