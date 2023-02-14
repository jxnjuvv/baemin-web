package web.baemin.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Coupon {

    private Long coupon_id;

    private int user_id;

    private String name;
    private String content;
    private int deducted_price;
    private int min_delivery_price;
    private String created_date;
    private String expired_date;
    private String modified_date;
    private String status;

}
