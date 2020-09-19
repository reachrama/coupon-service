package com.aerospace.service.ils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerospace.service.sip.ILSConfiguration;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NCIPProtocolConnector extends AbstractProtocolConnector {

  @Autowired
  public NCIPProtocolConnector(ILSConfiguration ilsConfiguration) {
    super(ilsConfiguration);
  }

  @Override
  public boolean supports(String s) {
    return "NCIP".equalsIgnoreCase(s);
  }

  @Override
  public String lookupItem(String itemIdentifier) {
    log.info("NCIP Lookup Item called");
    return null;
  }
}
