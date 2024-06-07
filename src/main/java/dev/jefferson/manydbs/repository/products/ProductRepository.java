package dev.jefferson.manydbs.repository.products;

import dev.jefferson.manydbs.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, String> {
}
