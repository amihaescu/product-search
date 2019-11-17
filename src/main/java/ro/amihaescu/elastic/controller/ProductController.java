package ro.amihaescu.elastic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.amihaescu.elastic.controller.dto.ProductCreationDTO;

@RestController("product")
public class ProductController {

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductCreationDTO productCreationDTO){
        return null;
    }
}
