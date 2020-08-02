package com.aerospace.repository;

import com.aerospace.model.Item;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends BaseRepository<Item>, JpaSpecificationExecutor<Item> {

    Item findByBarcode(String barcode);

}
