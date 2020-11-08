package com.aerospace.controller;

import com.aerospace.service.BaseService;
import com.aerospace.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import reactor.core.publisher.Flux;

public abstract class AbstractController<E extends AbstractEntity, S extends BaseService<E>>
    implements BaseController<E> {

    private final S service;

    @Autowired
    protected AbstractController(S service){
        this.service = service;
    }

    public S getService() {
       return this.service;
    }

    @Override
    public ResponseEntity<E> handleSave(@RequestBody E entity) throws Exception {
        E e =  service.save(entity);
        return  new ResponseEntity<E>(e,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<E> handleFetchAllBlocking() {
        return null;
    }

    @Override
    public Flux<E> handleFetchAllNonBlocking() {
        return null;
    }
}
