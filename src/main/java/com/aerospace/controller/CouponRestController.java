package com.aerospace.controller;

import com.aerospace.service.CouponService;
import com.aerospace.model.Coupon;
import com.aerospace.service.parser.ParserContentType;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/coupons")
@Slf4j
public class CouponRestController extends AbstractController<Coupon, CouponService> {

    protected CouponRestController(CouponService service) {
        super(service);
    }


    @GetMapping(value = "/non-blocking", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Coupon> getTweetsNonBlocking() {
        log.info("Starting NON-BLOCKING Controller!");
        Flux<Coupon> tweetFlux = WebClient.create()
                .get()
                .uri("http://localhost:8081/api/test/coupons")
                .retrieve()
                .bodyToFlux(Coupon.class);

        tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
        log.info("Exiting NON-BLOCKING Controller!");
        return tweetFlux;
    }


}
