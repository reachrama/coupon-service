package com.aerospace.repository;

import com.aerospace.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface  BaseRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
