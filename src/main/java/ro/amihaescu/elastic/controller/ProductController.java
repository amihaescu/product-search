package ro.amihaescu.elastic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.amihaescu.elastic.controller.dto.ProductCreationDTO;
import ro.amihaescu.elastic.model.Product;
import ro.amihaescu.elastic.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductCreationDTO productCreationDTO){
        Product savedProduct = productRepository.save(new Product(productCreationDTO));
        return ResponseEntity.ok(savedProduct.getId());
    }
}
