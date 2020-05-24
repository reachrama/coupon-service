package com.aerospace.service;

import com.aerospace.model.AbstractEntity;

public interface BaseService<E extends AbstractEntity> {
    E save(E entity);
}


