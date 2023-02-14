package web.baemin.ordershistory.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrdersMenuHistory {

    private String menu_name;
    private Long menu_count;
    private Long price;
}
