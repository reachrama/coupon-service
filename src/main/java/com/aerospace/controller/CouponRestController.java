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

    @GetMapping("/format/csv")
    public ResponseEntity<List<Coupon>> handleGetAllFromCsv() throws IOException {
        boolean test = true;
        Coupon coupon1 = new Coupon();
        coupon1.setCode("abcd");
        coupon1.setActive(false);
        Coupon coupon2 = null;
        test &= (null != coupon2);
        test &= (null != coupon2.getCode());
        System.out.println(test);


        return ResponseEntity.ok().body(getService().getAll(ParserContentType.CSV));
    }

    @GetMapping("/format/json")
    public ResponseEntity<List<Coupon>> getAllFromJson() throws IOException {
        return ResponseEntity.ok().body(getService().getAll(ParserContentType.JSON));
    }

    @GetMapping("/format/xml")
    public ResponseEntity<List<Coupon>> getAllFromXml() throws IOException {
        return ResponseEntity.ok().body(getService().getAll(ParserContentType.XML));
    }

}
