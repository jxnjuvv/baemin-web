package web.baemin.ordershistory.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.baemin.ordershistory.dto.OrdersHistory;
import web.baemin.ordershistory.mapper.OrdersHistoryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersHistoryServiceImpl implements OrdersHistoryService {


    private final OrdersHistoryMapper ordersHistoryMapper;

    @Override
    public List<OrdersHistory> ordersHistoryList(Long login_id) {
        List<OrdersHistory> ordersMenuHistoryList = ordersHistoryMapper.ordersHistoryList(login_id);
        for(int i = 0; i < ordersMenuHistoryList.size(); i++)
        {
            OrdersHistory current = ordersMenuHistoryList.get(i);
            current.setOrdersMenuHistoryList(ordersHistoryMapper.ordersMenuHistoryList(current.getOrder_id()));

        }
        System.out.println(ordersMenuHistoryList);
        return ordersMenuHistoryList;
    }

}
