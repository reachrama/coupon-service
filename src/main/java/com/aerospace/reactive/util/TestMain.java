package com.aerospace.reactive.util;

import java.time.Duration;
import java.time.Instant;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.aerospace.reactive.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMain {


  private static RestTemplate restTemplate = new RestTemplate();

  static {
    String baseUrl = "http://localhost:8081";
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
  }

  public static void main(String[] args) {
    Instant start = Instant.now();

    for (int i = 1; i <= 5; i++) {
      restTemplate.getForObject("/person/{id}", Person.class, i);
    }

    logTime(start);
  }

  private static void logTime(Instant start) {
    log.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
  }


}
