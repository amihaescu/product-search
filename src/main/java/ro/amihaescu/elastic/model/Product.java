package ro.amihaescu.elastic.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
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


}
