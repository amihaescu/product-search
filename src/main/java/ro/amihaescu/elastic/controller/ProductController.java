package ro.amihaescu.elastic.controller;

import lombok.extern.java.Log;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.amihaescu.elastic.controller.dto.ProductCreationDTO;
import ro.amihaescu.elastic.model.Product;
import ro.amihaescu.elastic.repository.ProductRepository;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@RestController
@RequestMapping("product")
@Log
public class ProductController {

    private final ProductRepository productRepository;
    private final Client client;

    public ProductController(ProductRepository productRepository, Client client) {
        this.productRepository = productRepository;
        this.client = client;
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductCreationDTO productCreationDTO) throws IOException {
        Product savedProduct = productRepository.save(new Product(productCreationDTO));
        client.prepareIndex("uploaded","products")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("id", savedProduct.getId())
                        .field("title", savedProduct.getTitle())
                        .field("price", savedProduct.getPrice())
                        .endObject()
                ).get();
        log.info(String.format("Indexed product %s to elastic search", savedProduct.getTitle()));
        return ResponseEntity.ok(savedProduct.getId());
    }
}
