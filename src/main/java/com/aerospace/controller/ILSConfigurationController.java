package com.aerospace.controller;

import com.aerospace.service.sip.ILSAbstractSIPProtocol;
import com.aerospace.service.sip.SIPConnectorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/ils")
@Slf4j
public class ILSConfigurationController {

    @Autowired
    private SIPConnectorFactory sipConnectorFactory;

    @GetMapping("/network/url")
    public ResponseEntity<String> handleGetAllFromCsv() throws IOException {

        ILSAbstractSIPProtocol jSIPProtocol = sipConnectorFactory.createSIPConnector("SIP", "nypl");
        log.info("*******************");
        return ResponseEntity.ok().body(jSIPProtocol.lookupItem("abc"));
    }
}
