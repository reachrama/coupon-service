package com.aerospace.service.sip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import com.aerospace.config.ILSPropertyConfiguration;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = ILSPropertyConfiguration.class)
@TestPropertySource("classpath:application.properties")
class ILSPropertyConfigurationTest {

    @Autowired
    private ILSPropertyConfiguration ilsPropertyConfiguration;

    @Test
    void getUrl() {
        assertEquals("htc_scsb", ilsPropertyConfiguration
                .getOperator().getUserId().get("nypl"));
        assertEquals("culpass", ilsPropertyConfiguration
                .getOperator().getPassword().get("cul"));
        assertEquals("pullocation", ilsPropertyConfiguration
                .getOperator().getLocation().get("pul"));

        assertEquals("https://qa-platform.nypl.org/api", ilsPropertyConfiguration
                .getBibData().getUrl().get("nypl"));

        assertEquals("nyplpatnypl", ilsPropertyConfiguration
                .getNypl().getPatron().getEddId().get("nypl"));



    }


}