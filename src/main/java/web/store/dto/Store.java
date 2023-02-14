package web.baemin.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Store {

    private Long store_id;

    private int food_category_cd;

    private String store_name;
    private String address;
    private String store_picture_url;
    private String phone;
    private String content;
    private int min_delivery_price;
    private String store_distance;
    private int delivery_tip;
    private int delivery_time;
    private String rating;
    private int dibs_count;
    private int review_count;
    private String created_date;
    private String modified_date;
    private String status;

}
