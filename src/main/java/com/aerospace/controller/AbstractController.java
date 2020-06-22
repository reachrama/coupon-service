package com.aerospace.controller;

import com.aerospace.service.BaseService;
import com.aerospace.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

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
}
