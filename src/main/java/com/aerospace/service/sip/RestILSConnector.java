package com.aerospace.service.sip;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestILSConnector extends ILSAbstractSIPProtocol {

    public RestILSConnector(ILSConfiguration ilsConfiguration, String instituteCode){
        super(ilsConfiguration, instituteCode);
    }

    @Override
    public String lookupItem(String itemIdentifier) {
        log.info("Rest SIP Connector");
        return null;
    }
}
