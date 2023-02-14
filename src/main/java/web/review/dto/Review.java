package web.baemin.review.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import web.baemin.ordershistory.dto.OrdersMenuHistory;

import java.util.List;

@Setter
@Getter
@ToString
public class Review {

    private Long review_id;
    private Long user_id;
    private Long order_id;
    private Long login_id;
    private String store_id;
    private String store_name;
    private String store_picture_url;
    private String menu_id;
    private String menu_name;
    private String rating;
    private String content;
    private String created_date;
    private String modified_date;
    private List<ReviewPicture> reviewPictureList;
    private List<OrdersMenuHistory> ordersMenuHistoryList;

}
