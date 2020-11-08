package com.aerospace.controller;

import com.aerospace.service.CouponService;
import com.aerospace.model.Coupon;
import com.aerospace.service.parser.ParserContentType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponRestController extends AbstractController<Coupon, CouponService> {

    protected CouponRestController(CouponService service) {
        super(service);
    }

}
