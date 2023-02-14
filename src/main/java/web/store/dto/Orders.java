package web.baemin.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Orders {

    private Long order_id;
    private Long user_id;
    private Long login_id;
    private Long store_id;
    private Long coupon_id;
    private List<OrdersMenu> ordersMenuList;

    private String order_address;
    private String detail_address;
    private Long order_phone;
    private Long total_price;
    private String requests;

    private String created_date;
    private String modified_date;
    private String status;

}
