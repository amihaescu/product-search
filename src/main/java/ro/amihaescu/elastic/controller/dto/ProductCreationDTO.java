package ro.amihaescu.elastic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreationDTO {

    @NotNull
    private double price;
    @NotNull
    private String title;
    @NotNull
    private String description;
    private List<String> tags;
    private List<String> images;
}
