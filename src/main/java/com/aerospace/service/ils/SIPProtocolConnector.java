package com.aerospace.service.ils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerospace.service.sip.ILSConfiguration;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SIPProtocolConnector extends AbstractProtocolConnector {

  @Autowired
  public SIPProtocolConnector(ILSConfiguration ilsConfiguration) {
    super(ilsConfiguration);
  }

  @Override
  public boolean supports(String s) {
    return "SIP".equalsIgnoreCase(s);
  }

  @Override
  public String lookupItem(String itemIdentifier) {
    log.info("SIP Lookup Item Called");
    return null;
  }
}
