package web.baemin.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Menu {

    private Long menu_id;
    private int store_id;

    private String menu_name;
    private int price;
    private String menu_url;
    private String created_date;
    private String modified_date;
    private String status;

}
