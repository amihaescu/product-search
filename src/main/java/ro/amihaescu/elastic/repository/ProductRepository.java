package ro.amihaescu.elastic.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.amihaescu.elastic.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
