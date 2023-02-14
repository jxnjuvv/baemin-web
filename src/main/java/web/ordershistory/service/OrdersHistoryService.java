package web.baemin.ordershistory.service;

import web.baemin.ordershistory.dto.OrdersHistory;

import java.util.List;

public interface OrdersHistoryService {
    List<OrdersHistory> ordersHistoryList(Long login_id);

}
