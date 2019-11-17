package ro.amihaescu.elastic.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.amihaescu.elastic.controller.dto.ProductCreationDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private double price;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @ElementCollection(targetClass = String.class)
    private List<String> tags;
    @ElementCollection(targetClass = String.class)
    private List<String> images;


    public Product(ProductCreationDTO productCreationDTO) {
        this.price = productCreationDTO.getPrice();
        this.title = productCreationDTO.getTitle();
        this.description = productCreationDTO.getDescription();
        this.tags = productCreationDTO.getTags();
        this.images = productCreationDTO.getImages();
    }
}
