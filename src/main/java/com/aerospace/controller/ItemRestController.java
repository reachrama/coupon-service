package com.aerospace.controller;

import com.aerospace.model.Item;
import com.aerospace.repository.specifications.ItemSpecification;
import com.aerospace.repository.specifications.SearchCriteria;
import com.aerospace.repository.specifications.SearchOperation;
import com.aerospace.service.ItemService;
import com.aerospace.service.RestTemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemRestController extends AbstractController<Item, ItemService> {

    @Autowired
    private RestTemplateHelper restTemplateHelper;

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
        itemSpecification.add(new SearchCriteria("itemName", "Book11", SearchOperation.CONTAINS));
        List<Item> itemList = this.getService().getAll(itemSpecification);
        return  ResponseEntity.ok().body( itemList );
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<Item> handleFetchByBarCode(@PathVariable String barcode) {

        Item item  = this.getService().findByBarcode(barcode);
        return  ResponseEntity.ok().body( item );

        /*WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build(); */

    }

    @GetMapping("/restcall/barcode/{barcode}")
    public Mono<ResponseEntity<Item>> handleRestFetchByBarCode(@PathVariable String barcode) {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8081/api/items")
                .build();

        return webClient.get()
                .uri("/barcode/" + barcode)
                .retrieve()
                .toEntity(Item.class);

    }


    @GetMapping("/restcall/institute/{instituteId}")
    public ResponseEntity<List<Item>> handleRestFetchByInstitution(@PathVariable String instituteId) {

        List<Item> itemList = restTemplateHelper.getForList(Item.class, "http://localhost:8081/api/items/institute/1");

        /*ItemSpecification itemSpecification = new ItemSpecification();
        itemSpecification.add(new SearchCriteria("owningInstId", instituteId, SearchOperation.EQUAL));
        itemSpecification.add(new SearchCriteria("itemName", "Book11", SearchOperation.MATCH_START));
        List<Item> itemList = this.getService().getAll(itemSpecification);*/
        return  ResponseEntity.ok().body( itemList );
    }

    @GetMapping("/restcall/temp")
    public void handleRestCall() throws IOException {

        URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/football_matches?year=2011");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();

        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));

            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            System.out.println("JSON String Result " + response.toString());

        } else {
            System.out.println("GET NOT WORKED");
        }






    }

}
