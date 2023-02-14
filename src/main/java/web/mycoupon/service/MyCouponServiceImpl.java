package web.baemin.mycoupon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.baemin.mycoupon.dto.MyCoupon;
import web.baemin.mycoupon.mapper.MyCouponMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyCouponServiceImpl implements MyCouponService {


    private final MyCouponMapper myCouponMapper;

    @Transactional
    @Override
    public List<MyCoupon> myCouponList(Long login_id) {

        myCouponMapper.myCouponUpdate(login_id);

        return myCouponMapper.myCouponList(login_id);
    }

}
