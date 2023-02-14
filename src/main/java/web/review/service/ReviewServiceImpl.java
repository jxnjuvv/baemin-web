package web.baemin.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.baemin.ordershistory.mapper.OrdersHistoryMapper;
import web.baemin.review.dto.Review;
import web.baemin.review.dto.ReviewPicture;
import web.baemin.review.mapper.ReviewMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper reviewMapper;
    private final OrdersHistoryMapper ordersHistoryMapper;

    @Override
    public List<Review> reviewList(Long login_id) {
        List<Review> reviewPictureList = reviewMapper.reviewList(login_id);
        for(int i = 0; i < reviewPictureList.size(); i++)
        {
            Review current = reviewPictureList.get(i);
            current.setReviewPictureList(reviewMapper.reviewPictureList(current.getReview_id()));
            current.setOrdersMenuHistoryList(ordersHistoryMapper.ordersMenuHistoryList(current.getOrder_id()));
        }
        System.out.println(reviewPictureList);
        return reviewPictureList;
    }


    @Override
    public void reviewInsert(Review review) {
        reviewMapper.reviewInsert(review);
        System.out.println("reviewInsert 진행됨.");
//        System.out.println(review.getReviewPictureList().isEmpty());
        if(review.getReviewPictureList() != null) {
            if (!review.getReviewPictureList().isEmpty()) {
                review.getReviewPictureList().forEach(reviewPicture -> {
                    System.out.println("for문 진입");
                    reviewPicture.setReview_id(review.getReview_id());
                    System.out.println("setReview_id 진행 중.");
                    reviewMapper.reviewPictureInsert(reviewPicture);
                    System.out.println("사진 픽쳐 인서트 됨");
                });
            }
            System.out.println("끝");
        }
    }

    @Override
    public void reviewDelete(Review review) {
        reviewMapper.reviewDelete(review);
    }

    @Override
    public List<ReviewPicture> reviewPictureList(Long review_id) {
        return reviewMapper.reviewPictureList(review_id);
    }

}
