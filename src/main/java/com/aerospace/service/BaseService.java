package com.aerospace.service;

import com.aerospace.model.AbstractEntity;
import com.aerospace.service.parser.ParserContentType;

import java.io.IOException;
import java.util.List;

public interface BaseService<E extends AbstractEntity> {
    E save(E entity);

    List<E> fetchAll() throws IOException;
}


