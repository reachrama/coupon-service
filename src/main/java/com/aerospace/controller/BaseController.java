package com.aerospace.controller;

import com.aerospace.model.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import reactor.core.publisher.Flux;

public interface BaseController<E extends AbstractEntity> {

    @PostMapping
    ResponseEntity<E> handleSave(@RequestBody E entity) throws Exception;

    @GetMapping
    ResponseEntity<E> handleFetchAllBlocking();

    @GetMapping
    Flux<E> handleFetchAllNonBlocking();


}
