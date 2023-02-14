package web.baemin.mycoupon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyCoupon {

    private Long coupon_id;

    private int user_id;
    private Long login_id;

    private String name;
    private String content;
    private int deducted_price;
    private int min_delivery_price;
    private String created_date;
    private String expired_date;
    private String modified_date;
    private String status;

}
