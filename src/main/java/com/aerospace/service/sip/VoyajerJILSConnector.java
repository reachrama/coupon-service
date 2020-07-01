package com.aerospace.service.sip;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VoyajerJILSConnector extends ILSAbstractSIPProtocol {

    public VoyajerJILSConnector(ILSConfiguration ilsConfiguration, String instituteCode){
        super(ilsConfiguration, instituteCode);
    }

    @Override
    public String lookupItem(String itemIdentifier) {
        log.info("JSIP Connector" + getHost());
        log.info("JSIP Connector" + getOperatorLocation());
        return null;
    }
}
