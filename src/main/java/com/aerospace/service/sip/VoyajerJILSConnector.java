package com.aerospace.service.sip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.aerospace.model.Coupon;
import com.aerospace.repository.CouponRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configurable
public class VoyajerJILSConnector extends ILSAbstractSIPProtocol {


    @Autowired
    private CouponRepository couponRepository;

    public VoyajerJILSConnector(ILSConfiguration ilsConfiguration, String instituteCode){
        super(ilsConfiguration, instituteCode);
    }

    @Override
    public String lookupItem(String itemIdentifier) {
        log.info("JSIP Connector" + getHost());
        log.info("JSIP Connector" + getOperatorLocation());

        List<Coupon> couponList = couponRepository.findAll();
        System.out.println(couponList);
        return null;
    }
}
