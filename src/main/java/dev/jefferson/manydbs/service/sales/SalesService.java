package dev.jefferson.manydbs.service.sales;

import dev.jefferson.manydbs.dto.sales.SalesRequest;
import dev.jefferson.manydbs.dto.sales.SalesResponse;
import dev.jefferson.manydbs.model.sales.Sales;
import dev.jefferson.manydbs.repository.sales.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository repository;


    @Transactional
    public SalesResponse create(SalesRequest request) {
        Sales entity = Sales.create(request);
        entity = repository.save(entity);
        return SalesResponse.create(entity);
    }


    public List<SalesResponse> findAll() {
        return repository.findAll().stream().map(SalesResponse::create).toList();
    }
}
