package web.baemin.ordershistory.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.ordershistory.dto.OrdersHistory;
import web.baemin.ordershistory.dto.OrdersMenuHistory;

import java.util.List;

@Mapper
public interface OrdersHistoryMapper {

    List<OrdersHistory> ordersHistoryList(Long login_id);
    List<OrdersMenuHistory> ordersMenuHistoryList(Long order_id);
}
