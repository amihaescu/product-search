package ro.amihaescu.elastic.controller.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductCreationDTO {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private double price;
    @NotNull
    private String title;
    @NotNull
    private String description;
    private List<String> tags;
    private List<String> images;
}
