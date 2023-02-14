package web.baemin.near.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
    private Long store_id;
    private Long food_category_cd;
    private String store_name;
    private String address;
    private String store_picture_url;
    private Long phone;
    private String content;
    private Double store_distance;
    private Double rating;
    private Long dibs_count;
    private Long review_count;
}
