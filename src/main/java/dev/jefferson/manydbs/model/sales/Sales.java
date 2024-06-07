package dev.jefferson.manydbs.model.sales;


import dev.jefferson.manydbs.dto.sales.SalesRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "sales")
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    @Id
    private String uuid;

    private String product;

    private BigDecimal price;

    public static Sales create(SalesRequest request) {
        return new Sales(UUID.randomUUID().toString(), request.getProduct(), request.getValue());
    }
}
