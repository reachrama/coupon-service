package com.aerospace.controller;

import com.aerospace.model.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<E extends AbstractEntity> {

    @PostMapping
    ResponseEntity<E> handleSave(@RequestBody E entity) throws Exception;

}
