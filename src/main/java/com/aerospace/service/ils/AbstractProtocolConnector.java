package com.aerospace.service.ils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.aerospace.service.sip.ILSConfiguration;


public abstract class AbstractProtocolConnector {

  private final ILSConfiguration ilsConfiguration;

  @Autowired
  public AbstractProtocolConnector(ILSConfiguration ilsConfiguration) {
    this.ilsConfiguration = ilsConfiguration;
  }

  public abstract boolean supports(String s);

  public abstract String lookupItem(String itemIdentifier);

  public String getHost() {
    return ilsConfiguration.getUrl().get("nypl");
  }

}
