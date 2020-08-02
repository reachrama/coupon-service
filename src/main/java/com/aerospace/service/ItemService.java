package com.aerospace.service;

import com.aerospace.model.Item;
import com.aerospace.repository.ItemRepository;
import com.aerospace.service.parser.ParserContentType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemService extends AbstractService<Item, ItemRepository> {

    public ItemService(ItemRepository repository) {
        super(repository);
    }

    public List<Item> getAll() {
        return this.repository.findAll();
    }

    public List<Item> getAll(Specification<Item> specification) {
        return this.repository.findAll(specification);
    }

    public Item findByBarcode(String barcode) {
        return this.repository.findByBarcode(barcode);
    }

    @Override
    public Item save(Item entity) {
        return null;
    }

    @Override
    public List<Item> getAll(ParserContentType contentType) throws IOException {
        return null;
    }
}
