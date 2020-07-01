package com.aerospace.service.sip;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "ils.network")
@Data
@Component
public class ILSConfiguration {

    private Map<String, String> url;
    private final Operator operator = new Operator();

    @Data
    public static class Operator {
        private Map<String, String> id;
        private Map<String, String> password;
        private Map<String, String> location;
    }
}
