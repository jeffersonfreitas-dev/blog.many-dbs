package dev.jefferson.manydbs.dto.product;

import dev.jefferson.manydbs.model.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String uuid;
    private String name;

    public static ProductResponse create(Product entity) {
        return new ProductResponse(entity.getUuid(), entity.getName());
    }
}
