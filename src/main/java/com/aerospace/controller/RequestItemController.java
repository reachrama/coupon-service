package com.aerospace.controller;

import com.aerospace.model.RequestItem;
import com.aerospace.service.RequestItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/request-item")
public class RequestItemController extends AbstractController<RequestItem, RequestItemService> {

    protected RequestItemController(RequestItemService service) {
        super(service);
    }


    @GetMapping("/patron-barcode/{patronBarcode}/item-barcode/{itemBarcode}")
    public ResponseEntity<List<RequestItem>> handleFetch(@PathVariable String patronBarcode,
                                                   @PathVariable String itemBarcode) {

        patronBarcode = "patronbar1";
        itemBarcode = "itembar1";

        List<RequestItem> requestItemList = this.getService().getByPatronBarCodeAndItemBarCode(patronBarcode, itemBarcode);

        requestItemList = this.getService().getByPatronBarCodeAndItemBarCode(patronBarcode, null);

       //requestItemList = this.getService().getByPatronBarCodeAndItemBarCode(null, null);
        return  ResponseEntity.ok().body(requestItemList);

    }
}
