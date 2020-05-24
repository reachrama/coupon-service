package com.aerospace.service;

import com.aerospace.repository.BaseRepository;
import com.aerospace.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<E extends AbstractEntity, R extends BaseRepository<E>>
    implements BaseService<E>{

    protected final R repository;

    @Autowired
    public AbstractService(R repository){
        this.repository = repository;
    }

}
