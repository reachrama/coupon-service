package com.aerospace.service.sip;

import org.junit.jupiter.api.Test;

public class SIPConnectorFactoryTest {

    @Test
    public void testMakePizzas() {
        BaseSIPConnectorFactory baseSIPConnectorFactory = new SIPConnectorFactory();
        ILSAbstractSIPProtocol jSIPProtocol = baseSIPConnectorFactory.createSIPConnector("SIP", "nypl");
        ILSAbstractSIPProtocol restSIPProtocol = baseSIPConnectorFactory.createSIPConnector("Rest", "nypl");

        jSIPProtocol.lookupItem("test");
    }
}
