package dev.jefferson.manydbs.model.products;


import dev.jefferson.manydbs.dto.product.ProductRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String uuid;

    private String name;

    public static Product create(ProductRequest request) {
        return new Product(UUID.randomUUID().toString(), request.getName());
    }
}
