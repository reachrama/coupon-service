package com.aerospace.service.ils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aerospace.service.sip.ILSAbstractSIPProtocol;
import com.aerospace.service.sip.RestILSConnector;
import com.aerospace.service.sip.VoyajerJILSConnector;

@Component
public class ILSProtocolConnectorFactory {

  private final List<AbstractProtocolConnector> protocolConnectors;

  @Autowired
  public ILSProtocolConnectorFactory(List<AbstractProtocolConnector> protocolConnectors) {
    this.protocolConnectors = protocolConnectors;
  }

  public AbstractProtocolConnector getIlsProtocolConnector(String protocol) {

    return protocolConnectors
            .stream()
            .filter(service -> service.supports(protocol))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);

  };

}
