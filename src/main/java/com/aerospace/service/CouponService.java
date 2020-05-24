package com.aerospace.service;

import com.aerospace.repository.CouponRepository;
import com.aerospace.model.Coupon;
import org.springframework.stereotype.Service;

@Service
public class CouponService extends AbstractService<Coupon, CouponRepository> {

    public CouponService(CouponRepository repository){
        super(repository);
    }

    @Override
    public Coupon save(Coupon entity) {
        return this.repository.save(entity);
    }
}
