package web.baemin.store.service;

import web.baemin.review.dto.Review;
import web.baemin.store.dto.*;

import java.util.List;

public interface StoreService {
    List<Store> storeList(String food_category_cd);

    List<Review> storeReviewList(Store store);

    Store storeRead(String store_id);

    List<Menu> menuList(String store_id);

    List<Coupon> couponList(Long login_id);

    void ordersInsert(Orders orders);

    void couponUpdate(Orders orders);
}
