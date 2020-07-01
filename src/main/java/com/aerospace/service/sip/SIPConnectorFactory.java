package com.aerospace.service.sip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SIPConnectorFactory extends BaseSIPConnectorFactory {

    @Autowired
    private ILSConfiguration ilsConfiguration;

    @Override
    public ILSAbstractSIPProtocol createSIPConnector(String protocol, String instituteCode) {

        ILSAbstractSIPProtocol connectorProtocol = null;
        if(protocol.equalsIgnoreCase("SIP")) {
            connectorProtocol = new VoyajerJILSConnector(ilsConfiguration, instituteCode);
        } else if (protocol.equalsIgnoreCase("REST")) {
            connectorProtocol = new RestILSConnector(ilsConfiguration, instituteCode);
        }
        return connectorProtocol;
    }
}
