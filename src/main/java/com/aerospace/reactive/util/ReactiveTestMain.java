package com.aerospace.reactive.util;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.aerospace.reactive.model.Person;

import lombok.extern.slf4j.Slf4j;


public class ReactiveTestMain {
  private static final Logger logger = LoggerFactory.getLogger(ReactiveTestMain.class);
  private static String baseUrl = "http://localhost:8081";
  private static WebClient client = WebClient.create(baseUrl);

  public static void main(String[] args) {

    Instant start = Instant.now();
    for (int i = 1; i <= 5; i++) {
      client.get().uri("/person/{id}", i).retrieve().bodyToMono(Person.class).subscribe();
    }
    logTime(start);
  }

  private static void logTime(Instant start) {
    logger.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
  }
}
