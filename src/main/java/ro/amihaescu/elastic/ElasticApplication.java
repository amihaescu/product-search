package ro.amihaescu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.amihaescu.elastic.controller.dto.ProductCreationDTO;
import ro.amihaescu.elastic.model.Product;

@SpringBootApplication
public class ElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticApplication.class, args);
	}



}
