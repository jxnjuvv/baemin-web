package web.baemin.mycoupon.service;

import web.baemin.mycoupon.dto.MyCoupon;

import java.util.List;

public interface MyCouponService {

    List<MyCoupon> myCouponList(Long login_id);
}
