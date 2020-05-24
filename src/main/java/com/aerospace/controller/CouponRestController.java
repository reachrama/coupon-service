package com.aerospace.controller;

import com.aerospace.service.CouponService;
import com.aerospace.model.Coupon;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
public class CouponRestController extends AbstractController<Coupon, CouponService> {

    protected CouponRestController(CouponService service) {
        super(service);
    }
}
