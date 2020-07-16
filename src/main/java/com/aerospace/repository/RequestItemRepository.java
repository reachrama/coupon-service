package com.aerospace.repository;

import com.aerospace.model.RequestItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestItemRepository extends BaseRepository<RequestItem>, JpaSpecificationExecutor<RequestItem> {

    List<RequestItem> findByPatronBarcodeAndItemBarcode(String patronBarCode, String itemBarCode);

    List<RequestItem> findByPatronBarcodeAndItemBarcode(String patronBarCode, String itemBarCode, Pageable pageable);

}
