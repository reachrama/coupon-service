package com.aerospace.controller;

import com.aerospace.model.Item;
import com.aerospace.repository.specifications.ItemSpecification;
import com.aerospace.repository.specifications.SearchCriteria;
import com.aerospace.repository.specifications.SearchOperation;
import com.aerospace.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemRestController extends AbstractController<Item, ItemService> {

    protected ItemRestController(ItemService service) {
        super(service);
    }

    @GetMapping
    public ResponseEntity<List<Item>> handleGetAll() {
        List<Item> itemList = this.getService().getAll();
        return  ResponseEntity.ok().body( itemList );
    }

    @GetMapping("/institute/{instituteId}")
    public ResponseEntity<List<Item>> handleFetchByInstitution(@PathVariable String instituteId) {
        ItemSpecification itemSpecification = new ItemSpecification();
        itemSpecification.add(new SearchCriteria("owningInstId", instituteId, SearchOperation.EQUAL));
        itemSpecification.add(new SearchCriteria("itemName", "Book11", SearchOperation.MATCH_START));
        List<Item> itemList = this.getService().getAll(itemSpecification);
        return  ResponseEntity.ok().body( itemList );
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<List<Item>> handleFetchByBarCode(@PathVariable String barcode) {
        return null;
    }
}
