package ro.amihaescu.elastic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ro.amihaescu.elastic.controller.dto.ProductCreationDTO;
import ro.amihaescu.elastic.model.Product;
import ro.amihaescu.elastic.repository.ProductRepository;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        productRepository.deleteAll();
    }

    @Test
    public void createProduct() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductCreationDTO productCreationDTO = ProductCreationDTO.builder()
                .title("Product 1")
                .description("Product 1 description")
                .price(100)
                .build();

        String response = mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(productCreationDTO)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Long resultingId = Long.valueOf(response);
        Optional<Product> productOptional = productRepository.findById(resultingId);

        assertTrue(productOptional.isPresent());
        Product product = productOptional.get();

        assertEquals("Product 1", product.getTitle());
        assertEquals("Product 1 description", product.getDescription());
        assertEquals(100L, product.getPrice());

    }

}
