package com.aerospace.service;

import com.aerospace.repository.CouponRepository;
import com.aerospace.model.Coupon;
import com.aerospace.service.parser.ParserContentType;
import com.aerospace.service.parser.ParserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Slf4j
public class CouponService extends AbstractService<Coupon, CouponRepository> {

    public CouponService(CouponRepository repository) {
        super(repository);
    }

    @Override
    public Coupon save(Coupon entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Coupon> fetchAll() throws IOException {
        return this.repository.findAll();
    }


}
