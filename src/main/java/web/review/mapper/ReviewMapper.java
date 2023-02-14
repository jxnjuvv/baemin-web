package web.baemin.review.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.review.dto.Review;
import web.baemin.review.dto.ReviewPicture;

import java.util.List;

@Mapper
public interface ReviewMapper {

    List<Review> reviewList(Long login_id);
    List<ReviewPicture> reviewPictureList(Long review_id);

    void reviewInsert(Review review);

    void reviewDelete(Review review);

    void reviewPictureInsert(ReviewPicture reviewPicture);
}
