package dev.jefferson.manydbs.dto.sales;

import dev.jefferson.manydbs.model.sales.Sales;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalesResponse {

    private String uuid;
    private String product;
    private BigDecimal value;

    public static SalesResponse create(Sales entity) {
        return new SalesResponse(entity.getUuid(), entity.getProduct(), entity.getPrice());
    }
}
