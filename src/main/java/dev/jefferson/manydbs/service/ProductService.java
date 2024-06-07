package dev.jefferson.manydbs.service;

import dev.jefferson.manydbs.dto.product.ProductRequest;
import dev.jefferson.manydbs.dto.product.ProductResponse;
import dev.jefferson.manydbs.model.products.Product;
import dev.jefferson.manydbs.repository.products.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;


    @Transactional
    public ProductResponse create(ProductRequest request) {
        Product entity = Product.create(request);
        entity = repository.save(entity);
        return ProductResponse.create(entity);
    }


    public List<ProductResponse> findAll() {
        return repository.findAll().stream().map(ProductResponse::create).toList();
    }
}
