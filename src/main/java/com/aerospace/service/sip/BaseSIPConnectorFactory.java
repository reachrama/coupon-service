package com.aerospace.service.sip;

public abstract class BaseSIPConnectorFactory {

    public abstract ILSAbstractSIPProtocol createSIPConnector(String  protocol, String instituteCode);

}
