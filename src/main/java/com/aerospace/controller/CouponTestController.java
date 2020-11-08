package com.aerospace.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerospace.model.Coupon;

@RestController
public class CouponTestController {

  @GetMapping("/api/test/coupons")
  private List<Coupon> getAllTweets() throws Exception {
    Thread.sleep(2000L); // delay

    Coupon coupon1 = new Coupon();
    coupon1.setCode("RELAX");
    coupon1.setDiscount(new BigDecimal("10.00"));

    Coupon coupon2 = new Coupon();
    coupon2.setCode("TSI");
    coupon2.setDiscount(new BigDecimal("15.00"));

    Coupon coupon3 = new Coupon();
    coupon3.setCode("HAPPY");
    coupon3.setDiscount(new BigDecimal("20.00"));

    return Arrays.asList(
            coupon1,coupon2,coupon3);
  }


}
