package com.aerospace.repository;

import com.aerospace.model.Coupon;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository  extends BaseRepository<Coupon> {

    Coupon findByCode(String code);

}
