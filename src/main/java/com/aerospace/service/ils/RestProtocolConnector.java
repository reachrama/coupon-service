package com.aerospace.service.ils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerospace.repository.CouponRepository;
import com.aerospace.service.sip.ILSConfiguration;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestProtocolConnector extends AbstractProtocolConnector {

  @Autowired
  private CouponRepository couponRepository;

  @Autowired
  public RestProtocolConnector(ILSConfiguration ilsConfiguration) {
    super(ilsConfiguration);
  }

  @Override
  public boolean supports(String s) {
    return "REST".equalsIgnoreCase(s);
  }

  @Override
  public String lookupItem(String itemIdentifier) {
    log.info("Rest Lookup Item called");
    log.info("*********" + getHost());
    couponRepository.findAll();
    return null;

  }
}
