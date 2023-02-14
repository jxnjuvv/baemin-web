package web.baemin.mycoupon.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.mycoupon.dto.*;

import java.util.List;

@Mapper
public interface MyCouponMapper {

    List<MyCoupon> myCouponList(Long login_id);

    void myCouponUpdate(Long login_id);

}
