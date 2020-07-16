package com.aerospace.repository;

import com.aerospace.model.Item;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends BaseRepository<Item>, JpaSpecificationExecutor<Item> {


}
