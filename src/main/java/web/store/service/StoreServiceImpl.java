package web.baemin.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.baemin.ordershistory.mapper.OrdersHistoryMapper;
import web.baemin.review.dto.Review;
import web.baemin.review.mapper.ReviewMapper;
import web.baemin.store.dto.*;
import web.baemin.store.mapper.StoreMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreServiceImpl implements StoreService {


    private final StoreMapper storeMapper;
    private final ReviewMapper reviewMapper;
    private final OrdersHistoryMapper ordersHistoryMapper;

    @Override
    public List<Store> storeList(String food_category_cd) {
        return storeMapper.storeList(food_category_cd);
    }

    @Override
    public List<Review> storeReviewList(Store store) {


        List<Review> storeReviewList = storeMapper.storeReviewList(store);
        for(int i = 0; i < storeReviewList.size(); i++)
        {
            Review current = storeReviewList.get(i);
            current.setReviewPictureList(reviewMapper.reviewPictureList(current.getReview_id()));
            current.setOrdersMenuHistoryList(ordersHistoryMapper.ordersMenuHistoryList(current.getOrder_id()));
        }
        System.out.println(storeReviewList);
        return storeReviewList;
    }



    @Override
    public Store storeRead(String store_id) {
        return storeMapper.storeRead(store_id);
    }

    @Override
    public List<Menu> menuList(String store_id) {
        return storeMapper.menuList(store_id);
    }

    @Override
    public List<Coupon> couponList(Long login_id) {
        return storeMapper.couponList(login_id);
    }

    @Transactional
    @Override
    public void ordersInsert(Orders orders) {

        storeMapper.ordersInsert(orders);
        orders.getOrdersMenuList().forEach(ordersMenu -> {
           ordersMenu.setOrder_id(orders.getOrder_id());
           storeMapper.ordersMenuInsert(ordersMenu);
        });

    }

    @Override
    public void couponUpdate(Orders orders) {
        storeMapper.couponUpdate(orders);
    }

}
