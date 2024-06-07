package dev.jefferson.manydbs.repository.sales;

import dev.jefferson.manydbs.model.sales.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, String> {
}
