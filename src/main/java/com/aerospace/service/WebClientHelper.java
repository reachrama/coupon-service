package com.aerospace.service;

import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@Slf4j
public class WebClientHelper {

    public WebClient webClient;

    public <T> List<T> getForList(Class<T> clazz, String url, Object... uriVariables) {
        try {
            webClient = WebClient.builder()
                    .baseUrl(url)
                    .defaultHeader(HttpHeaders.USER_AGENT, "Hello Koding")
                    .defaultCookie("cookie name", "cookie value")
                    .build();

        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.info("No data found {}", url);
            } else {
                log.info("rest client exception {}  ", exception.getMessage());
            }
        }
        return null;
    }


}
