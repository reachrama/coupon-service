package com.aerospace.service.sip;

/**
 * (ILS) Integrated Library System - (SIP) - Session Initiated Protocol
 * This class holds all abstract methods, which needs to be implemented by the  Integrated Library System (ILS) class
 * which extends this class.
 */
public abstract class ILSAbstractSIPProtocol {

    protected ILSConfiguration ilsConfiguration;
    protected String instituteCode;

    public ILSAbstractSIPProtocol(ILSConfiguration ilsConfiguration, String instituteCode) {
        this.ilsConfiguration = ilsConfiguration;
        this.instituteCode = instituteCode;
    }

    public String getHost() {
        return ilsConfiguration.getUrl().get(instituteCode);
    }

    public String getOperatorUserId() {
        return ilsConfiguration.getOperator().getId().get(instituteCode);
    }

    public String getOperatorPassword() {
        return ilsConfiguration.getOperator().getPassword().get(instituteCode);
    }

    public String getOperatorLocation() {
        return ilsConfiguration.getOperator().getLocation().get(instituteCode);
    }

    public abstract String lookupItem(String itemIdentifier);
}
