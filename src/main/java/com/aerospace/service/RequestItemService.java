package com.aerospace.service;

import com.aerospace.model.RequestItem;
import com.aerospace.repository.RequestItemRepository;
import com.aerospace.repository.specifications.RequestItemWithItemBarCode;
import com.aerospace.repository.specifications.RequestItemWithPatronBarCode;
import com.aerospace.service.parser.ParserContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RequestItemService  extends AbstractService<RequestItem, RequestItemRepository> {

    public RequestItemService(RequestItemRepository repository) {
        super(repository);
    }

    public List<RequestItem> getByPatronBarCodeAndItemBarCode(String patronBarcode,
                                                              String itemBarCode) {

        Specification<RequestItem> spec = Specification.where(new RequestItemWithPatronBarCode(patronBarcode))
                .and(new RequestItemWithItemBarCode(itemBarCode));
        return this.repository.findAll(spec);
       // return this.repository.findByPatronBarcodeAndItemBarcode(patronBarcode, itemBarCode);
    }


    @Override
    public RequestItem save(RequestItem entity) {
        return null;
    }

    @Override
    public List<RequestItem> fetchAll() throws IOException {
        return null;
    }
}
