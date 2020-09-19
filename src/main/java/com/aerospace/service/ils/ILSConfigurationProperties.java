package com.aerospace.service.ils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aerospace.service.sip.ILSConfiguration;

@Component
public class ILSConfigurationProperties {

  @Autowired
  private ILSConfiguration ilsConfiguration;




}
